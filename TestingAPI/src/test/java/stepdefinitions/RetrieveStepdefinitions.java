package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static org.junit.Assert.assertEquals;


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
    public void theResponseShouldContainTheExpectedUserInformation() throws ParseException {
        String responseBody = response.getBody().asString();

        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);

        JSONObject userData = (JSONObject) jsonResponse.get("data");

        assertEquals(2L, userData.get("id")); // Verificar el ID del usuario
        assertEquals("janet.weaver@reqres.in", userData.get("email")); // Verificar el email
        assertEquals("Janet", userData.get("first_name")); // Verificar el primer nombre
        assertEquals("Weaver", userData.get("last_name")); // Verificar el apellido
        assertEquals("https://reqres.in/img/faces/2-image.jpg", userData.get("avatar")); // Verificar el avatar
    }
}
