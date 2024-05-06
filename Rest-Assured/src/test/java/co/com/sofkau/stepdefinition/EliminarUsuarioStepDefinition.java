package co.com.sofkau.stepdefinition;

import co.com.sofkau.setup.SetupJsonPlaceholder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class EliminarUsuarioStepDefinition extends SetupJsonPlaceholder {

    private String userId;
    private Response response;

    @Given("que se requiere eliminar el usuario con ID {int}")
    public void queSeRequiereEliminarElUsuarioConID(int userId) {
        this.userId = String.valueOf(userId);
    }

    @When("se llama el servicio para eliminar usuario")
    public void seLlamaElServicioParaEliminarUsuario() {
        response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/" + userId);
    }

    @Then("el sistema deberia responder con un codigo de estado HTTP 200 OK")
    public void elSistemaDeberiaResponderConUnCodigoDeEstadoHTTPOK() {
        response.then().statusCode(HttpStatus.SC_OK);
    }
}
