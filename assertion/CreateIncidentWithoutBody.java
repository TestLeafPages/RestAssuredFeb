package learn.assertion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class CreateIncidentWithoutBody {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		File file = new File("./CreateIncidentSchema.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then().assertThat()
				.body(matchesJsonSchema(file))
				.extract()
				.response()
				;
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
