package basic;

import java.io.File;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
				
		Response response = RestAssured
				.given()
				.pathParam("sys-id", "63edd3502f722010e6575e972799b6e6")
				.delete("{sys-id}");
		response.prettyPrint();
		System.out.println( response.getStatusCode());
		
		
		

	}

}
