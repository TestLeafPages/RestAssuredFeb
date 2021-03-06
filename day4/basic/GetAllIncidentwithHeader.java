package basic;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentwithHeader {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
							.given()
							.header("accept", "application/xml")
							.pathParam("sys_id", "46c03489a9fe19810148cd5b8cbf501e")
							.get("{sys_id}");
	//	https://dev102438.service-now.com/api/now/table/incident/46c03489a9fe19810148cd5b8cbf501e/46c03489a9fe19810148cd5b8cbf501e
		
		response.prettyPrint();


		
		
		
		
		
		

	}

}
