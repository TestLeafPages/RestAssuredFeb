package learn.assertion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static  org.hamcrest.Matchers.*;
public class GetAllIncident {

	@Test
	public void getAllIncident() {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number, sys_id")
				.queryParam("sysparm_limit", "10")
				.get()
				.then().assertThat()
				//.body("result.number", hasItems("INC0000012"))
				.body("result.number[0]", containsString("12"))
				.extract().response()
				;
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
