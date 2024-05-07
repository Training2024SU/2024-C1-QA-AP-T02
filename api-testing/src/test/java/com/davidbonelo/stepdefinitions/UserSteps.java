package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.User;
import com.davidbonelo.models.UserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.davidbonelo.ApiEndpoints.LOGIN_ENDPOINT;
import static com.davidbonelo.ApiEndpoints.USERS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserSteps {
    private User user;
    private String token;
    private Response response;

    @Given("A user is logged in")
    public void aUserIsLoggedIn() {
        user = UserFactory.getRegisteredUser();
        RequestSpecification request = given().contentType(ContentType.JSON).body("{\"email\": " +
                "\"" + user.getEmail() + "\",\"password\": \"" + user.getPassword() + "\"}");
        String response = request.post(LOGIN_ENDPOINT).asString();
        token = JsonPath.from(response).getString("token");
    }

    @When("he requests its profile data")
    public void heRequestsItsProfileData() {
        RequestSpecification request = given().contentType(ContentType.JSON);
        request.header("Authorization", "Bearer " + token);
        response = request.when().get(USERS_ENDPOINT + "/" + user.getId());
    }

    @Then("he should see his correct information")
    public void heShouldSeeHisCorrectInformation() {
        response.then()
                .statusCode(200)
                .body("data.id", equalTo(user.getId()))
                .body("data.email", equalTo(user.getEmail()))
                .body("data.first_name", equalTo(user.getFirstName()))
                .body("data.last_name", equalTo(user.getLastName()))
                .body("data.avatar", equalTo(user.getAvatarLink()));
    }
}
