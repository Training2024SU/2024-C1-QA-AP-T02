package co.com.sofkau.stepdefinition;


import co.com.sofkau.setup.SetupJsonPlaceholder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
public class EliminarUsuarioStepDefinition extends SetupJsonPlaceholder {

    private int userId;
    private Response response;

    @Given("que se requiere eliminar el usuario con ID {int}")
    public void queSeRequiereEliminarElUsuarioConID(int userId) {
        this.userId = userId;
    }

    @When("se llama el servicio DELETE para eliminar usuario")
    public void seLlamaElServicioParaEliminarUsuario() {
        try {
            response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/" + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("el sistema deberia responder con un codigo de estado HTTP 202")
    public void elSistemaDeberiaResponderConUnCodigoDeEstadoHTTP202() {
        try {
            assertEquals(HttpStatus.SC_ACCEPTED, response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}