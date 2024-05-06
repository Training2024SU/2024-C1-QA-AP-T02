package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

public class RetrieveStepdefinitions {

    private Response response;

    @Given("the user service is online")
    public void theUserServiceIsOnline() {
        // No es necesario implementar nada aqui
    }

    @When("a GET request is made to {string}")
    public void aGETRequestIsMadeTo(String endpoint) {
        // Realizar la solicitud GET al endpoint proporcionado
        response = RestAssured.get(endpoint);
    }

    @Then("the response should have status code {int}")
    public void theResponseShouldHaveStatusCode(int expectedStatusCode) {
        // Verificar el código de estado de la respuesta
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain the expected user information")
    public void theResponseShouldContainTheExpectedUserInformation() {
        // Verificar la información del usuario en la respuesta
        response.then()
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }
}
