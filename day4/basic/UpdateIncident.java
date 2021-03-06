package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {

	@Test
	public void createIncident() {
//"63edd3502f722010e6575e972799b6e6
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		File file = new File("./UpdateIncident.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("sys-id", "63edd3502f722010e6575e972799b6e6")
				.body(file)
				.put("{sys-id}");
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
