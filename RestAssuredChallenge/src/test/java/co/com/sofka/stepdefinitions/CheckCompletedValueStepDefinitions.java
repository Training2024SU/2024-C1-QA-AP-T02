package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CheckCompletedValueStepDefinitions extends CommonFunctions {
    Response response;
    String endpoint;

    @Given("queries by Id {int}")
    public void queriesById(Integer id) {
        endpoint = getTodosByUserId(id);
    }

    @When("executes the todos request")
    public void executesTheTodosRequest() {
        response = given().get(endpoint);
    }

    @Then("the completed valued should be true")
    public void theCompletedValuedShouldBeTrue() {
        response.then().assertThat().body(COMPLETED, equalTo(true));
        System.out.println( BODY_TEST2_TODOS +response.body().prettyPrint());
    }
    @Then("the status code shown would be {int}")
    public void theStatusCodeShownWouldBe(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(CODE_TEST2_TODOS + response.statusCode());
    }
}
