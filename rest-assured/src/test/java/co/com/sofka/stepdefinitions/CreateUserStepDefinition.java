package co.com.sofka.stepdefinitions;

import co.com.sofka.model.reqress.UserPostModel;
import co.com.sofka.model.reqress.UserPostResponseModel;
import co.com.sofka.util.SetModelData;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserStepDefinition extends Setup {
    private UserPostModel userPostModel;
    private final Gson gson = new Gson();


    @Given("the user is currently on the reqres.in platform.")
    public void theUserIsCurrentlyOnTheReqresInPlatform() {
        RestAssured.baseURI = "https://reqres.in";
        request = RestAssured.given();
    }

    @When("the user correctly enters their details")
    public void theUserCorrectlyEntersTheirDetails(DataTable dataTable) {
        String PUT_USER_URL = "/api/users";

        List<Map<String, String>> userDataList = dataTable.asMaps(String.class, String.class);
        userPostModel = SetModelData.mapUserPostModelData(userDataList);
        String json = gson.toJson(userPostModel);


        request.header("Content-Type", "application/json");
        request.body(json);
        response = request.post(PUT_USER_URL);
    }

    @Then("they should be able to view their information along with a generated ID")
    public void theyShouldBeAbleToViewTheirInformationAlongWithAGeneratedID() {

        // Deserialization from json
        String jsonResponseString = response.asString();
        UserPostResponseModel userResponse = new Gson().fromJson(jsonResponseString,
                UserPostResponseModel.class);

        // Compare response model with sent model
        assertThat(userResponse.getId(), notNullValue());
        assertThat(userResponse.getName(), equalTo(userPostModel.getName()));
        assertThat(userResponse.getJob(), equalTo(userPostModel.getJob()));
    }

}
