package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserStepDefinitions extends CommonFunctions {
    Response response;
    String requestBody;

    @Given("the user's in the web page {string}")
    public void theUserSInTheWebPage(String url) {
        RestAssured.baseURI = url;
    }

    @When("types information for a new user {string} {string}")
    public void typesInformationForANewUser(String name, String job) {
        requestBody = requestBodyUser(name, job);
    }

    @When("sends the create user request")
    public void sendsTheCreateUserRequest() {
        response = given().contentType(ContentType.JSON).body(requestBody).when().post(USERS_ENDPOINT);
    }

    @Then("should get a response with status code {int}")
    public void shouldGetAResponseWithStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(CODE_TEST1_USER + response.statusCode());
    }

    @Then("the name shown should be {string}")
    public void theNameShownShouldBe(String name) {
        response.then().assertThat().body("name", equalTo(name));
        System.out.println(BODY_TEST1_USER + response.body().prettyPrint());
        System.out.println("");
    }
}
