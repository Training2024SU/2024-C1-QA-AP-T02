package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.LOGIN_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUnsuccessfulStepDefinitions extends CommonFunctions {
    Response response;
    String requestBody;
    @When("enter the credentials {string} {string}")
    public void enterTheCredentials(String email, String password) {
        requestBody = requestBodyLogin(email, password);
        response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post(LOGIN_ENDPOINT);
    }
    @Then("the status code shown should be {int}")
    public void theStatusCodeShownShouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("should get a message {string}")
    public void shouldGetAMessage(String errorMessage) {
        response.then().assertThat().body("error", equalTo(errorMessage));
    }

}
