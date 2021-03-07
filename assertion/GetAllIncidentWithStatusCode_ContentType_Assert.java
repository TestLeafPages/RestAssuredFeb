package learn.assertion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllIncidentWithStatusCode_ContentType_Assert {

	@Test
	public void getAllIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		 
		Response response = RestAssured
				.given()
//				.accept(ContentType.XML)
//				.header("accept","application/xml")
				.get()
				//Test
				.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract()
				.response()
				;
		
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
