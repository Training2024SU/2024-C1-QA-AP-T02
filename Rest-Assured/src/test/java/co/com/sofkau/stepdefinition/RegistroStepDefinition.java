package co.com.sofkau.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.notNullValue;


public class RegistroStepDefinition{

    @Given("que el usuario ingresa sus datos correctamente")
    public void elUsuarioIngresaSuEmailYPaswordCorrectamente() {
        RestAssured.given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}");
    }

    @When("el usuario llama el servicio para registrarse")
    public void elUsuarioLlamaElServicioParaRegistrarse() {
        RestAssured.given().post("https://reqres.in/api/register");
    }

    @Then("el servicio deberia responder con un estado HTTP 200 OK")
    public void elServicioDeberiaResponderConUnCodigoDeEstadoHTTPOk() {
        RestAssured.given().then().statusCode(HttpStatus.SC_OK);
    }

    @Then("deberia visualizar su id y token asignados")
    public void deberiaVisualizarSuIdYTokenAsignados() {
        RestAssured.given().then().body("token", notNullValue());
    }
}
