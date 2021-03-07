package learn.assertion;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class CreateIncidentWithBodyAssert {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{ \"short_description\": \"keyboard issue\", \"category\" : \"Hardware\" }")
				.post()
				.then()
				.assertThat()
				// Path of the field
//				.body("result.short_description",equalTo("keyboard issue"))
				.body("result.short_description",containsString("keyboard1"))
				.extract()
				.response()
				;
		
		
		
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
