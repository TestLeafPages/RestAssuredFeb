package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends Common{

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
		
		JsonPath jsonPath = response.jsonPath();
		sys_id = jsonPath.get("result.sys_id");
		
		System.out.println( response.getStatusCode());
	}

}
