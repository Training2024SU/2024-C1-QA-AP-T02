package garcia.juan.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonUsersSD {

    public Response response;

    @Given("the JSONAPI endpoint for users is accessible")
    public void theJSONAPIEndpointForUsersIsAccessible() {
        // No necesitamos realizar ninguna acción aquí, simplemente establecemos el contexto
    }

    @Then("the response status code must be {int}")
    public void theResponseStatusCodeShouldBe(int int1) {
        response.then().statusCode(int1);
    }

    @When("sends a GET request to the users endpoint")
    public void sendsAGETRequestToTheUsersEndpoint() {
        // Envía una solicitud GET al endpoint "/users"
        response =  given().
                when().
                get("https://jsonplaceholder.typicode.com/users");
    }

    @Then("the response should contain at least one user with a valid name")
    public void theResponseShouldContainAtLeastOneUserWithAValidName() {
        // Verifica que la respuesta tenga un código de estado 200 OK
        // y que contenga al menos un usuario con un nombre válido
        response.then().
                statusCode(200).
                body("size()", greaterThan(0)).
                body("name", notNullValue());
    }
}
