package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserStepDefinitions {

    private Response response;
    private Map<String, Object> userData = new HashMap<>();

    @Given("que soy un usuario que quiere autenticarse")
    public void queSoyUnUsuarioQueQuiereAutenticarse() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Given("que tengo los siguientes datos :")
    public void queTengoLosSiguientesDatos(Map<String, String> userDataMap) {
        userData.putAll(userDataMap);
    }

    @When("envía una solicitud POST para crear un nuevo usuario")
    public void envíaUnaSolicitudPOSTParaCrearUnNuevoUsuario() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/api/users");
            System.out.println(userData);
    }

    @Then("la respuesta debería de ser el código de estado {int}")
    public void laRespuestaDeberíaDeSerElCódigoDeEstado(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("la respuesta debería de ser el código de estado: "+ expectedStatusCode);
    }

    @Then("el contenido de la respuesta deberia ser un JSON")
    public void elContenidoDeLaRespuestaDeberiaSerUnJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería contener los detalles del nuevo usuario")
    public void laRespuestaDeberíaContenerLosDetallesDelNuevoUsuario() {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("id"));
        assertTrue(responseBody.contains("createdAt"));
        userData.forEach((key, value) -> assertTrue(responseBody.contains(value.toString())));
    }
}
