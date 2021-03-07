package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentSteps {

	Response response = null;

	@Given("Set the EndPoint")
	public void setURL() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
	}

	@And("Set the Authorization")
	public void setAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}

	@When("Send the request as Post")
	public void createIncidentWithoutBody() {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
	}

	@Then("Confirm the status code is {int} found")
	public void verifyStatusCode(int code) {
		response
		.then().assertThat()
		.statusCode(code);
	}

	@And("print the response")
	public void printResponse() {
		response.prettyPrint();
	}

}
