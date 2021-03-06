package basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithParseResponse {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.pathParam("sys_id", "46c03489a9fe19810148cd5b8cbf501e")
				.get("{sys_id}");
		//need to parse json
		JsonPath jsonPath = response.jsonPath();
		// path of "created by"
		String createdBy = jsonPath.get("result.short_description");
		String category = jsonPath.get("result.category");
		
		System.out.println(createdBy);
		
	}

}
