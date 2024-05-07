package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class DeletePostStepDefinition extends Setup {
    @Given("the user is registered on the jsonplaceholder platform")
    public void theUserIsRegisteredOnTheJsonplaceholderPlatform() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        request = RestAssured.given();
    }

    @When("the user deletes its post with id {int} successfully")
    public void theUserDeletesItsPostWithIdSuccessfully(Integer id) {
        String DELETE_URL = "/posts/{id}";
        response = request
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(DELETE_URL);
    }
}
