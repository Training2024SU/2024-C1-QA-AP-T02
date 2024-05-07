package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.POSTS_ENDPOINT;
import static io.restassured.RestAssured.given;

public class UpdateAPostStepDefinitions extends CommonFunctions {
    Response response;
    String endpointById;
    String requestBody;

    @Given("with post id {int}")
    public void withPostId(Integer postId) {
        endpointById = getPostsById(postId);
    }

    @When("type information for update  {int} {string} {string}")
    public void typeInformationForUpdate(Integer id, String titleUpdated, String bodyUpdated) {
        requestBody = requestBodyPosts(id, titleUpdated, bodyUpdated);
    }

    @When("executes the request")
    public void executesTheRequest() {
        response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                put(endpointById);
    }

    @Then("should receive status code {int}")
    public void shouldReceiveStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
