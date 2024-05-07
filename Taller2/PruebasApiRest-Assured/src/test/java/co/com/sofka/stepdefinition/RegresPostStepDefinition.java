package co.com.sofka.stepdefinition;


import co.com.sofka.model.UserRegresPostModel;
import co.com.sofka.utils.Utils;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static co.com.sofka.stepdefinition.constants.ConstantStepDefinition.*;
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegresPostStepDefinition {

    private RequestSpecification request;
    private Response response;
    private UserRegresPostModel userRegresPostModel;


    @Given("the user is in the platform")
    public void theUserIsInThePlatform() {
        RestAssured.baseURI = REGRES_POST_SD_ONE;
        request = RestAssured.given();
    }
    @When("the user correctly enters their details")
    public void theUserCorrectlyEntersTheirDetails(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> userDetails = dataTable.asMap(String.class, String.class);
        userRegresPostModel = Utils.extractUserDetails(userDetails);
        response = request.body(userDetails).post(REGRES_POST_SD_THREE);

        Gson gson = new Gson();
        String json = gson.toJson(userRegresPostModel);

        request.header(JSON_CONTENT_TYPE, JSON_APPLICATION);
        request.body(json);
        response = request.post(REGRES_POST_SD_TWO);

        System.out.println(json);
    }

    @Then("it should see his information in the system")
    public void itShouldSeeHisInformationInTheSystem() {
        response.then().assertThat().body(REGRES_POST_SD_ASSERTION_ONE, equalTo(userRegresPostModel.getName()));
        response.then().assertThat().body(REGRES_POST_SD_ASSERTION_TWO, equalTo(userRegresPostModel.getJob()));
    }

    @Then("it should get a {int} code")
    public void itShouldGetACode(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

}
