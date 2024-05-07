package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteAPostStepDefinitions extends CommonFunctions {
    Response response;
    String endpointById;

    @Given("the post id to delete is {int}")
    public void thePostIdToDeleteIs(Integer postId) {
        endpointById = getPostsById(postId);
    }

    @When("executes the delete request")
    public void executesTheDeleteRequest() {
        response = given().delete(endpointById);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

}
