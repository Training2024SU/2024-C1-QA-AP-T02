package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateUserStepDefinitions extends CommonFunctions {
    Response response;
    String endpoint;
    String requestBody;

    @Given("with user id {int}")
    public void withUserId(Integer userId) {
        endpoint = getUserById(userId);
    }

    @When("type information to the user {string} {string}")
    public void typeInformationToTheUser(String name, String job) {
        requestBody = requestBodyUser(name, job);
        response = given().body(requestBody).contentType(ContentType.JSON).when().put(endpoint);
    }

    @Then("the status code for the update should be {int}")
    public void theStatusCodeForTheUpdateShouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the name should be {string}")
    public void theNameShouldBe(String nameUpdated) {
        response.then().assertThat().body("name", equalTo(nameUpdated));
    }
}
