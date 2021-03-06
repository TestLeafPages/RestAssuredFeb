package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentWithParseXMLResponse {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
//				.header("","")
				.accept(ContentType.XML)
//				.pathParam("sys_id", "46c03489a9fe19810148cd5b8cbf501e")
				.get(/*"{sys_id}"*/);
//		response.prettyPrint();
		//need to parse json
		XmlPath xmlPath = response.xmlPath();
		// path of "created by"
		List<String> short_description = xmlPath.getList("response.result.short_description");
		
		List<String> sysID = xmlPath.getList("response.result.sys_id");
		
		int size = short_description.size();
		
		System.out.println(short_description.get(size-1));
		System.out.println(sysID.get(size-1));
		
	}

}
