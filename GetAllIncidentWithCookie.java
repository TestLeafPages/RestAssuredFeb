package basic;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentWithCookie {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID","3F4FE50B7E74141366DA6691E536029A")//browser
				.get();
		response.prettyPrint();
		System.out.println( response.getStatusCode());
		
		//(key , value) -> Entry(map)
		/*Map<String, String> cookies = response.getCookies();
		
		for ( Entry<String, String> eachentry : cookies.entrySet()) {
			System.out.println(eachentry.getKey()+" : "+eachentry.getValue());
		}
		*/
		
	}

}
