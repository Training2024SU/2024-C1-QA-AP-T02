package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static co.com.sofka.Constants.CODE_TEST4_USER;
import static io.restassured.RestAssured.given;

public class DeleteUserStepDefinitions extends CommonFunctions {
    Response response;
    String endpointById;

    @Given("has the user with id {int}")
    public void hasTheUserWithId(Integer userId) {
        endpointById = getUserById(userId);
    }

    @When("executes the request for deleting")
    public void executesTheRequestForDeleting() {
        response = given().delete(endpointById);
    }

    @Then("should has a code {int}")
    public void shouldHasACode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(CODE_TEST4_USER + response.statusCode());
    }
}
