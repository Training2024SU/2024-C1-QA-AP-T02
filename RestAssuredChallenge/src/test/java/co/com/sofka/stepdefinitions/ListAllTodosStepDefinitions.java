package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.sofka.Constants.SIZE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListAllTodosStepDefinitions extends CommonFunctions {
    Response response;
    String endpoint;

    @Given("the user is browsing the web page {string}")
    public void theUserIsBrowsingTheWebPage(String url) {
        RestAssured.baseURI = url;
    }

    @Given("and queries by userId {int}")
    public void andQueriesByUserId(Integer userId) {
        endpoint = getAllTodosByUserId(userId);
    }

    @When("sends the todos request")
    public void sendsTheTodosRequest() {
        response = given().get(endpoint);
    }

    @Then("the amount of todos should be {int}")
    public void theAmountOfTodosShouldBe(Integer todosAmount) {
        response.then().assertThat().body(SIZE,equalTo(todosAmount));
    }
    @Then("the status code would be {int}")
    public void theStatusCodeWouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
