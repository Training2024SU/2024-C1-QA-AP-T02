package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static co.com.sofka.Constants.BODY_TEST2_USER;
import static co.com.sofka.Constants.CODE_TEST2_USER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUsersStepDefinitions extends CommonFunctions {
    Response response;

    @When("requests for all users")
    public void requestsForAllUsers() {
        response = given().get(getAllUsers());
    }

    @Then("total pages should be {int}")
    public void totalPagesShouldBe(Integer totalPages) {
        response.then().assertThat().body("total_pages", equalTo(totalPages));
        System.out.println(BODY_TEST2_USER + response.body().prettyPrint());
    }

    @Then("the status code should get a {int}")
    public void theStatusCodeShouldGetA(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(CODE_TEST2_USER + response.statusCode());
        System.out.println("");
    }
}
