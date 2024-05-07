package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.Constants.TODOS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateATodoStepDefinitions extends CommonFunctions {
    Response response;
    String requestBody;
    boolean completedValue;

    @Given("types information for a new todo for the user {int} {string} {string}")
    public void typesInformationForANewTodoForTheUser(Integer id, String title, String completed) {
        completedValue = Boolean.parseBoolean(completed);
        requestBody = requestBodyTodo(id, title, completedValue);
    }

    @When("executes the creation request")
    public void executesTheCreationRequest() {
        response=given().contentType(ContentType.JSON).body(requestBody).post(TODOS_ENDPOINT);
    }

    @Then("should has a status code {int}")
    public void shouldHasAStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("in the title space should be {string}")
    public void inTheTitleSpaceShouldBe(String title) {
        response.then().assertThat().body("title", equalTo(title));
    }

}
