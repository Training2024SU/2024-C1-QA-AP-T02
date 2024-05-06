package co.com.sofka.stepdefinitions;

import co.com.sofka.model.UserPostModel;
import co.com.sofka.util.SetModelData;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateUserStepDefinition extends Setup {
    private UserPostModel userPostModel;

    @Given("the user is currently on the reqres.in platform.")
    public void theUserIsCurrentlyOnTheReqresInPlatform() {
        RestAssured.baseURI = "https://reqres.in";
        request = RestAssured.given();
    }

    @When("the user correctly enters their details")
    public void theUserCorrectlyEntersTheirDetails(io.cucumber.datatable.DataTable dataTable) {
        String PUT_USER_URL = "/api/users";

        List<Map<String, String>> userDataList = dataTable.asMaps(String.class, String.class);
        userPostModel = SetModelData.setUserPostModelData(userDataList);

        Gson gson = new Gson();
        String json = gson.toJson(userPostModel);

        request.header("Content-Type", "application/json");
        request.body(json);
        response = request.post(PUT_USER_URL);
    }

    @Then("they should be able to view their information along with a generated ID")
    public void theyShouldBeAbleToViewTheirInformationAlongWithAGeneratedID() {
        response.then().assertThat().body("id", notNullValue());
        response.then().assertThat().body("name", equalTo(userPostModel.getName()));
        response.then().assertThat().body("job", equalTo(userPostModel.getJob()));
    }

}
