package co.com.sofka.stepdefinitions;

import co.com.sofka.model.reqress.UserGetModel;
import co.com.sofka.util.SetModelData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinition extends Setup {


    @Given("the user is registered on the reqres.in platform")
    public void theUserIsRegisteredOnTheReqresInPlatform() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("the user enters their registered ID {int} in the database")
    public void theUserEntersTheirRegisteredIDInTheDatabase(Integer id) {
        String GET_USER_URL = "/api/users/{id}";
        response = given()
                .pathParam("id", id)
                .when()
                .get(GET_USER_URL);
    }

    @Then("they should be able to view their information")
    public void theyShouldBeAbleToViewTheirInformation(DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        System.out.println(userData);
        UserGetModel expectedUser = SetModelData.mapUserGetModelData(userData);
        response.then().assertThat().body("data.id", equalTo(Integer.parseInt(expectedUser.getId())));
        response.then().assertThat().body("data.email", equalTo(expectedUser.getEmail()));
        response.then().assertThat().body("data.first_name", equalTo(expectedUser.getFirstName()));
        response.then().assertThat().body("data.last_name", equalTo(expectedUser.getLastName()));
    }

    @Then("the response should have a valid status code of {int}")
    public void theResponseShouldHaveAValidStatusCodeOf(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
