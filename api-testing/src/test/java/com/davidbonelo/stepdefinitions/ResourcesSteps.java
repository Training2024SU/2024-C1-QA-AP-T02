package com.davidbonelo.stepdefinitions;

import com.davidbonelo.ApiEndpoints;
import com.davidbonelo.models.Resource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ResourcesSteps extends ApiEndpoints {
    Resource resource;
    Response response;

    @Given("the resource with id {int}")
    public void theResourceWithId(int resourceId) {
        resource = new Resource();
        resource.setId(resourceId);
    }

    @When("the system requests the resource's info")
    public void theSystemRequestsTheResourceSInfo() {
        RequestSpecification request = given();
        response = request.get(RESOURCES_ENDPOINT + "/" + resource.getId());
    }

    @Then("it should receive a success response")
    public void itShouldReceiveASuccessResponse() {
        response.then().statusCode(200);
    }

    @And("it should obtain the complete resource's info with id {int} and name {string}")
    public void itShouldObtainTheCompleteResourceSInfoWithIdIdAndName(int id, String resourceName) {
        response.then()
                .body("data.id", equalTo(id))
                .body("data.name", equalTo(resourceName))
                .body("data.year", notNullValue(Integer.class))
                .body("data.color", notNullValue())
                .body("data.pantone_value", notNullValue());
    }
}
