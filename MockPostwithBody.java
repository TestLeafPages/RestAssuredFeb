package mock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockPostwithBody {

	/*@BeforeMethod
	public void postStub() {
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse()
				.withStatus(201)
				.withBody("{\"Name\" : \"Wire Mock\"}")
				.withHeader("Content-Type", "application/json")));
	}*/
		
	@Test
	public void mockPost() {
		
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.statusCode(201)
				.contentType(ContentType.JSON).extract().response();
		response.prettyPrint();
	}
	
}
