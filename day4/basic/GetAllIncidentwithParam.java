package basic;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentwithParam {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//Way 1
	/*	Response response = RestAssured
							.given()
							.queryParam("sysparm_fields", "number, sys_id")
							.queryParam("sysparm_limit", "10")
							.get();
		
		response.prettyPrint();*/

		
//Way 2
		HashMap<String,String> params = new HashMap<String,String>();
		params.put("sysparm_fields", "number, sys_id");
		params.put("sysparm_limit", "5");
		
		
		Response response = RestAssured
				.given()
				.queryParams(params)
				.get();
		
		response.prettyPrint();
		
		
		
		
		
		

	}

}
