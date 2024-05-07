package garcia.juan.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ListUsersSD extends SetUp {


    @Given("the reqres API endpoint for users is accessible")
    public void theReqresAPIEndpointForUsersIsAccessible() {
        //There is no need to do anything here in this case
    }

    @When("sends the query Get to the system with page parameter set to {int}")
    public void sendsTheQueryGetToTheSystemWithPageParameterSetTo(int pageNumber) {
        response = given().
                param("page", pageNumber).
                when().
                get("https://reqres.in/api/users");
    }
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int int1) {
        response.then().statusCode(int1);
    }
    @Then("the response should contain user data")
    public void theResponseShouldContainUserData() {
        response.then().log().all().body("data", not(empty()));
    }

    @Then("each user in the response should have a valid id")
    public void eachUserInTheResponseShouldHaveAValidId() {
        String jsonResponse = response.getBody().asString();
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray dataArray = jsonObject.getAsJsonArray("data");

        for (JsonElement user : dataArray) {
            JsonObject userData = user.getAsJsonObject();
            assertTrue("Any user must have a valid ID", userData.has("id"));
        }
    }

    @Then("each user in the response should have a valid email")
    public void eachUserInTheResponseShouldHaveAValidEmail() {
        String jsonResponse = response.getBody().asString();
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray dataArray = jsonObject.getAsJsonArray("data");

        for (JsonElement user : dataArray) {
            JsonObject userData = user.getAsJsonObject();
            assertTrue("Any user must have an email", userData.has("email"));
        }
    }

    @Then("the response body should not contain user data")
    public void theResponseBodyShouldNotContainUserData() {
        response.then()
                .body("data", empty());
    }

}
