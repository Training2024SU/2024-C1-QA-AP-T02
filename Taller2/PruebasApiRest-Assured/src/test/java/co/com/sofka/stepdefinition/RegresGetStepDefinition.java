package co.com.sofka.stepdefinition;

import co.com.sofka.model.UserRegresGetModel;
import co.com.sofka.utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static co.com.sofka.stepdefinition.constants.ConstantStepDefinition.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegresGetStepDefinition {

    private Response response;

    @Given("the user is registered on the reqres.in platform")
    public void theUserIsRegisteredOnTheReqresInPlatform() {
        RestAssured.baseURI = REGRES_GET_SD_ONE;

    }

    @When("the user enters their registered ID {int} in the database")
    public void theUserEntersTheirRegisteredIDInTheDatabase(Integer id) {

        response = given()
                .pathParam(REGRES_GET_SD_THREE, id)
                .when()
                .get(REGRES_GET_SD_TWO);
    }

    @Then("they should be able to view their information")
    public void theyShouldBeAbleToViewTheirInformation(DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);

        System.out.println(userData);

        UserRegresGetModel expectedUser = Utils.extractUserDetails(userData);

        response.then().assertThat().body(REGRES_GET_SD_ASSERTION_ONE, equalTo(Integer.valueOf(expectedUser.getId())));
        response.then().assertThat().body(REGRES_GET_SD_ASSERTION_TWO, equalTo(expectedUser.getEmail()));
        response.then().assertThat().body(REGRES_GET_SD_ASSERTION_THREE, equalTo(expectedUser.getFirstName()));
        response.then().assertThat().body(REGRES_GET_SD_ASSERTION_FOUR, equalTo(expectedUser.getLastName()));
    }

    @Then("the response should have a valid status code of {int}")
    public void theResponseShouldHaveAValidStatusCodeOf(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}

