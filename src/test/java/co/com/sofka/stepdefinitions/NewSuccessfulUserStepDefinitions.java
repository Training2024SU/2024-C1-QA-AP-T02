package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewSuccessfulUserStepDefinitions {

    private Response response;

    @Given("que soy un usuario autenticado")
    public void queSoyUnUsuarioAutenticado() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("creo un nuevo usuario con los siguientes detalles:")
    public void creoUnNuevoUsuarioConLosSiguientesDetalles(io.cucumber.datatable.DataTable dataTable) {
        String name = dataTable.cell(1, 0);
        String email = dataTable.cell(1, 1);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"" + name + "\", \"email\": \"" + email + "\"}")
                .when()
                .post("/api/users");
        System.out.println("{\"name\": \"" + name + "\", \"email\": \"" + email + "\"}");

    }

    @Then("el código de estado de la respuesta debería de ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDeberíaDeSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("el código de estado de la respuesta es: " + expectedStatusCode);
    }

    @Then("el tipo de contenido de la respuesta debería ser un JSON")
    public void elTipoDeContenidoDeLaRespuestaDeberíaSerUnJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería contener los detalles del usuario creado")
    public void laRespuestaDeberíaContenerLosDetallesDelUsuarioCreado() {
        assertTrue(response.getBody().asString().contains("name"));
        assertTrue(response.getBody().asString().contains("email"));

    }
}
