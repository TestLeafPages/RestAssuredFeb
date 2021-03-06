package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{ \"short_description\": \"keyboard issue\", \"category\" : \"Hardware\" }")
				.post();
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
