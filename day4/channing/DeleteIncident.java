package channing;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident extends Common {

	@Test(dependsOnMethods = {"channing.UpdateIncident.updateIncident"})
	public void deleteIncident() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
				
		Response response = RestAssured
				.given()
				.pathParam("sys-id", sys_id)
				.delete("{sys-id}");
		response.prettyPrint();
		System.out.println( response.getStatusCode());
		
		
		

	}

}
