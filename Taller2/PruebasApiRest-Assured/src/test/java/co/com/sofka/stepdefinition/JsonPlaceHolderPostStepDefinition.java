package co.com.sofka.stepdefinition;

import co.com.sofka.model.JsonPlaceHolderWebPostModel;
import co.com.sofka.utils.Utils;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static co.com.sofka.stepdefinition.constants.ConstantStepDefinition.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPlaceHolderPostStepDefinition {

    private RequestSpecification request;
    private Response response;
    private JsonPlaceHolderWebPostModel jsonPlaceHolderWebPostModel;

    @Given("the user is in the web platform")
    public void theUserIsInTheWebPlatform() {
        RestAssured.baseURI = JSON_POST_SD_URL;
        request = RestAssured.given();
    }

    @When("the user correctly enters their post details")
    public void theUserCorrectlyEntersTheirPostDetails(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> webPostDetails = dataTable.asMaps(String.class, String.class);
        jsonPlaceHolderWebPostModel = Utils.extractWebPostDetails(webPostDetails);

        Gson gson = new Gson();
        String json = gson.toJson(jsonPlaceHolderWebPostModel);

        request.header(JSON_CONTENT_TYPE, JSON_APPLICATION);
        request.body(json);
        response = request.post(JSON_POST_SD_ONE);

        System.out.println(json);

    }

    @Then("it should see his webpost in the system")
    public void itShouldSeeHisWebpostInTheSystem() {
        response.then().assertThat().body(JSON_POST_SD_ASSERTION_ONE, equalTo(jsonPlaceHolderWebPostModel.getUserId()));
        response.then().assertThat().body(JSON_POST_SD_ASSERTION_TWO, equalTo(Integer.parseInt(jsonPlaceHolderWebPostModel.getId())));
        response.then().assertThat().body(JSON_POST_SD_ASSERTION_THREE, equalTo(jsonPlaceHolderWebPostModel.getTitle()));
        response.then().assertThat().body(JSON_POST_SD_ASSERTION_FOUR, equalTo(jsonPlaceHolderWebPostModel.getBody()));
    }

    @Then("it should get a {int} code succesfully")
    public void itShouldGetACodeSuccesfully(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}
