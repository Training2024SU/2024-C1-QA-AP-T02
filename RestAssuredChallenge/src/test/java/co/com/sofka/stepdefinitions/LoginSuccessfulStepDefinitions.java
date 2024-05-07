package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.LOGIN_ENDPOINT;
import static co.com.sofka.Constants.POSTS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginSuccessfulStepDefinitions extends CommonFunctions {
    Response response;
    String requestBody;

    @Given("the user browses the web page {string}")
    public void theUserBrowsesTheWebPage(String url) {
        RestAssured.baseURI = url;
    }

    @When("uses the credentials {string} {string}")
    public void usesTheCredentials(String email, String password) {
        requestBody = requestBodyLogin(email, password);
        response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post(LOGIN_ENDPOINT);
    }

    @Then("the status code in the login should be {int}")
    public void theStatusCodeInTheLoginShouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("should get a token {string}")
    public void shouldGetAToken(String token) {
        response.then().assertThat().body("token", equalTo(token));
    }
}
