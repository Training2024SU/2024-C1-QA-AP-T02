package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.POSTS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreatePostsStepDefinitions extends CommonFunctions {
    Response response;
    String requestBody;

    @Given("the user is in the web page {string}")
    public void theUserIsInTheWebPage(String url) {
        RestAssured.baseURI = url;
    }

    @When("types information for a new post {string} {string}")
    public void typesInformationForANewPost(String title, String body) {
        requestBody = requestBodyPosts(title, body);
    }

    @When("sends the request")
    public void sendsTheRequest() {
        response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post(POSTS_ENDPOINT);
    }

    @Then("should receive a response with status code {int}")
    public void shouldReceiveAResponseWithStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the title should be {string}")
    public void theTitleShouldBe(String title) {
        response.then().assertThat().body("title", equalTo(title));
    }


}
