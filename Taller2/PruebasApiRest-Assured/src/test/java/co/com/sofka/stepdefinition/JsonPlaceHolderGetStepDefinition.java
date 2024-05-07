package co.com.sofka.stepdefinition;

import co.com.sofka.model.JsonPlaceHolderWebPostModel;
import co.com.sofka.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.sofka.stepdefinition.constants.ConstantStepDefinition.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolderGetStepDefinition {

    private Response response;

    @Given("the user is registered on the Json placeholder platform")
    public void theUserIsRegisteredOnTheJsonPlaceholderPlatform() {
        RestAssured.baseURI = JSON_POST_SD_URL;
    }
    @When("the user enters the registered ID {int} of the post in the database")
    public void theUserEntersTheRegisteredIDOfThePostInTheDatabase(Integer id) {

        response = given()
                .pathParam(JSON_GET_SD_TWO, id)
                .when()
                .get(JSON_GET_SD_ONE);
    }

    @Then("should be able to view the post information")
    public void shouldBeAbleToViewThePostInformation(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> postData = dataTable.asMaps(String.class, String.class);
        System.out.println(postData);

        JsonPlaceHolderWebPostModel expectedPost = Utils.extractWebPostDetails(postData);


        response.then().assertThat().body(JSON_GET_SD_ASSERTION_ONE, equalTo(Integer.parseInt(expectedPost.getUserId())));
        response.then().assertThat().body(JSON_GET_SD_ASSERTION_TWO, equalTo(Integer.parseInt(expectedPost.getId())));
        response.then().assertThat().body(JSON_GET_SD_ASSERTION_THREE, equalTo(expectedPost.getTitle()));
        response.then().assertThat().body(JSON_GET_SD_ASSERTION_FOUR, equalTo(expectedPost.getBody()));
    }

    @Then("the server response should have a valid status code of {int}")
    public void theServerResponseShouldHaveAValidStatusCodeOf(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
