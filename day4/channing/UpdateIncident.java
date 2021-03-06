package channing;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends Common{
//								packageName.className.methodName
	@Test(dependsOnMethods = {"channing.CreateIncidentWithoutBody.createIncident"})
	public void updateIncident() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		File file = new File("./UpdateIncident.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("sys-id", sys_id)
				.body(file)
				.put("{sys-id}");
		response.prettyPrint();
		System.out.println( response.getStatusCode());
	}

}
