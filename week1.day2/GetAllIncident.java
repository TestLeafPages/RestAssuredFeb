package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	public static void main(String[] args) {
//		step 1: Get URI / Endpoint for the server
		//call method -> ClassName.MethodName();
//		call variable -> ClassName.variable;
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
//		step 2: Authentication (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step 3: Request type (Get()) ctrl + 2, l 
		Response response = RestAssured.get();
//		step 5: Prite response body
		response.prettyPrint();
//		step 4: validate (status code - 200)
		System.out.println( response.getStatusCode());
	}

}
