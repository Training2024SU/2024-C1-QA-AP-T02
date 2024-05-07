package garcia.juan.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.cucumber.messages.internal.com.google.common.base.Predicates.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UserRegisterSD {

    private String name;
    private String job;
    private Response response;


    @Given("the user is currently on the reqres.in platform.")
    public void theUserIsCurrentlyOnTheReqresInPlatform() {

    }

    @When("the user correctly enters their details")
    public void theUserCorrectlyEntersTheirDetails(io.cucumber.datatable.DataTable dataTable) {
        name = dataTable.cell(1, 0);
        job = dataTable.cell(1, 1);
    }

    @When("send the request for the user creation")
    public void sendTheRequestForTheUserCreation() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        String jsonBody = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";

        response = request.body(jsonBody).post("https://reqres.in/api/users");
    }

    @Then("they should be able to view their information along with a generated ID")
    public void theyShouldBeAbleToViewTheirInformationAlongWithAGeneratedID() {

        Assert.assertTrue(response.getBody().asString().contains("id"));
        Assert.assertTrue(response.getBody().asString().contains(name));
        Assert.assertTrue(response.getBody().asString().contains(job));
    }

    @Then("the response should indicate a valid status code of {int}")
    public void theResponseShouldIndicateAValidStatusCodeOf(Integer int1) {
        response.then().statusCode(int1);
    }

    @When("the user attempts to create an account with only job specified")
    public void theUserAttemptsToCreateAnAccountWithOnlyJobSpecified(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("they should receive a response with a status code of {int} indicating bad request")
    public void theyShouldReceiveAResponseWithAStatusCodeOfIndicatingBadRequest(Integer int1) {
        //response.then().statusCode(int1);
        Assert.assertEquals(Optional.ofNullable(int1), response.getStatusCode());
    }
}
