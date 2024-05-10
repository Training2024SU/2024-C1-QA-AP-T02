package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizedPostCreationStepDefinitions {

    private Response response;

    @Given("soy un usuario que se encuentra autenticado")
    public void soyUnUsuarioQueSeEncuentraAutenticado() {
    }

    @Given("que estoy autenticado")
    public void queEstoyAutenticado() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("envio una solicitud POST para crear un nuevo post")
    public void envioUnaSolicitudPOSTParaCrearUnNuevoPost() {
        String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts");
        System.out.println(requestBody);
    }

    @Then("el codigo de estado de la respuesta deberia de ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDeberiaDeSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode(), "El codigo de estado de la respuesta es el esperado");
        System.out.println("El codigo de estado de la respuesta es el esperado : "+ expectedStatusCode);
    }
}