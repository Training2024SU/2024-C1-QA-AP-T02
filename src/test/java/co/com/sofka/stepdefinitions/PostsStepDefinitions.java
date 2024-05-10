package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostsStepDefinitions {

    private Response response;

    @Given("soy un usuario autenticado")
    public void soyUnUsuarioAutenticado() {
        // Implementación de autenticación si es necesario
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("solicito los detalles del post con ID {int}")
    public void solicitoLosDetallesDelPostConID(int postId) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/" + postId);
        System.out.println(RestAssured.given());
    }

    @Then("el código de estado de la respuesta debería ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDeberíaSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("El codigo de estado de la respuesta deberia ser : "+ expectedStatusCode);

    }

    @Then("el tipo de contenido de la respuesta debería ser JSON")
    public void elTipoDeContenidoDeLaRespuestaDeberíaSerJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería contener los siguientes campos:")
    public void laRespuestaDeberíaContenerLosSiguientesCampos(io.cucumber.datatable.DataTable dataTable) {
        String responseBody = response.getBody().asString();
        dataTable.asList().forEach(field -> assertTrue(responseBody.contains(field)));
        System.out.println("la respuesta debería contener los siguientes campos :"+ response.getBody().asString());

    }
}
