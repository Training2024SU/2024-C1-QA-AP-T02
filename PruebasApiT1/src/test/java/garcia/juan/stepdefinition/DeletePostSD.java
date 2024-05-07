package garcia.juan.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

public class DeletePostSD extends SetUp{

    @Given("the JSONPlaceholder API endpoint for posts is accessible")
    public void theJSONPlaceholderAPIEndpointForPostsIsAccessible() {
    }

    @Given("there exists a post with id {int}")
    public void thereExistsAPostWithId(int int1) {
    }

    @When("sends a DELETE request to the post endpoint with id {int}")
    public void sendsADELETERequestToThePostEndpointWithId(int int1) {
        response = delete("https://jsonplaceholder.typicode.com/posts/{postId}", int1);
    }

    @Then("the response delete status code must be {int} deleting the user")
    public void theResponseStatusCodeShouldBeDeletingTheUser(int int1) {
        response.then().statusCode(int1);
    }

    @Given("there exists no post with id {int}")
    public void thereExistsNoPostWithId(Integer int1) {

    }
    @Then("the response delete status code must be {int} indicating resource not found")
    public void theResponseDeleteStatusCodeMustBeIndicatingResourceNotFound(Integer int1) {
        response.then().statusCode(int1);
    }

}
