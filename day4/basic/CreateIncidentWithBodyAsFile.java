package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//To get the file path
		File file = new File("./CreateIncident.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file)
				.post();
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
