package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ParseResponseWithGetList {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.get();
		//need to parse json
		JsonPath jsonPath = response.jsonPath();
		// path of sys_id => getList
		Object list = jsonPath.get("result.sys_id[1]");
		
		System.out.println(list);
//		for (String eachSysID : list) {
//			System.out.println(eachSysID);
//		}
		
//		System.out.println(list);
		
	}

}
