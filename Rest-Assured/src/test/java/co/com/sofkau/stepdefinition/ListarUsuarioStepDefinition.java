package co.com.sofkau.stepdefinition;

import co.com.sofkau.setup.SetupReqrest;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ListarUsuarioStepDefinition extends SetupReqrest {
    private Response response;

    @When("se llama el servicio listar un solo usuario por su id")
    public void seLlamaElServicioListarUnSoloUsuario() {
        response = RestAssured.given().get("https://reqres.in/api/users/2");
        RestAssured.given().log().all();
        RestAssured.given().contentType(ContentType.JSON);
    }

    @Then("el servicio deberia responder con un codigo de estado HTTP 200 OK")
    public void elSistemaDeberiaResponderConUnCodigoDeEstadoHTTPOK() {
        RestAssured.given().log().all();
        response.then().statusCode(HttpStatus.SC_OK);
    }

    @Then("se deberia visualizar los detalles del usuario correctamente")
    public void seDeberiaVisualizarLosDetallesDelUsuarioCorrectamente() {
        response.then().body("data.id", equalTo(2)); // Verifica que el ID sea igual a 2
        response.then().body("data", notNullValue()); // Verifica que los detalles del usuario no sean nulos
    }
}
