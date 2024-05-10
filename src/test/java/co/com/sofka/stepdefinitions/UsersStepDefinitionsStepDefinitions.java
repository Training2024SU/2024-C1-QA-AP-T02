package co.com.sofka.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsersStepDefinitionsStepDefinitions {

    private Response response;
    private Map<String, Object> userDetails;

    @Given("que soy un usuario autenticado correctamente")
    public void queSoyUnUsuarioAutenticadoCorrectamente() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("solicito los detalles del usuario con el ID {int}")
    public void solicitoLosDetallesDelUsuarioConElID(int userId) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/" + userId);
    }

    @Then("el codigo de estado de la respuesta deberia de ser un {int}")
    public void elCodigoDeEstadoDeLaRespuestaDeberiaDeUnSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("la respuesta deberia de ser un JSON")
    public void laRespuestaDeberiaDeSerUnJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería de contener los siguientes campos:")
    public void laRespuestaDeberíaDeContenerLosSiguientesCampos(io.cucumber.datatable.DataTable dataTable) {
        String responseBody = response.getBody().asString();
        dataTable.asList().forEach(field -> assertTrue(responseBody.contains(field)));
    }

    @Given("que tengo detalles de usuario actualizados")
    public void queTengoDetallesDeUsuarioActualizados() {
        userDetails = new HashMap<>();
        userDetails.put("name", "John Doe");
        userDetails.put("job", "QA Engineer");
    }

    @When("envío una solicitud PUT para actualizar el usuario con ID {int}")
    public void envíoUnaSolicitudPUTParaActualizarElUsuarioConID(int userId) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userDetails)
                .when()
                .put("/api/users/" + userId);
    }

    @Then("la respuesta debería tener el código de estado {int}")
    public void laRespuestaDeberíaTenerElCódigoDeEstado(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("La respuesta tiene el codigo de Estado : "+ expectedStatusCode);

    }

    @Then("el contenido de la respuesta debería ser JSON")
    public void elContenidoDeLaRespuestaDeberíaSerJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería contener los detalles actualizados del usuario")
    public void laRespuestaDeberíaContenerLosDetallesActualizadosDelUsuario() {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("updatedAt"));
        assertTrue(responseBody.contains("name"));
        assertTrue(responseBody.contains("job"));
        System.out.println("La respuesta contiene los detalles actualizados del usuario" + response.getBody().asString());

    }
}
