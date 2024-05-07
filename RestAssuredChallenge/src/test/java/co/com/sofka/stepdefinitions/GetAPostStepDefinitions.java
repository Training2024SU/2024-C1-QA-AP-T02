package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static co.com.sofka.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAPostStepDefinitions extends CommonFunctions {
    Response response;
    String endpointById;

    @Given("has one posts id {int}")
    public void hasOnePostsId(Integer postId) {
        endpointById = getPostsById(postId);
    }

    @When("requests for the id")
    public void requestsForTheId() {
        response = given().get(endpointById);
    }

    @Then("should has for title {string}")
    public void shouldHasForTitle(String title) {
        response.then().assertThat().body(TITLE, equalTo(title));
        System.out.println(BODY_TEST2_POSTS + response.body().prettyPrint());
    }
    @Then("should has status code {int}")
    public void shouldHasStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(CODE_TEST2_POSTS + response.statusCode());
    }
}
