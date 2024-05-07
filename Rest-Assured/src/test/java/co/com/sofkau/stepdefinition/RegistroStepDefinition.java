package co.com.sofkau.stepdefinition;

import co.com.sofkau.setup.SetupReqrest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.notNullValue;import io.restassured.response.Response;


public class RegistroStepDefinition extends SetupReqrest {
    private Response response;

    @Given("que el usuario ingresa sus datos correctamente")
    public void elUsuarioIngresaSuEmailYPaswordCorrectamente() {
        try {
            System.out.println("Request ->");
            RestAssured.given()
                    .contentType("application/json")
                    .body("{\n" +
                            "    \"email\": \"eve.holt@reqres.in\",\n" +
                            "    \"password\": \"pistol\"\n" +
                            "}")
                    .log().all();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("el usuario llama el servicio POST para registrarse")
    public void elUsuarioLlamaElServicioParaRegistrarse() {
        try {
            response = RestAssured.given()
                    .post("https://reqres.in/api/register")
                    .then()
                    .log().all() // Imprime detalles de la respuesta en la consola
                    .extract().response(); // Extrae la respuesta para su posterior uso
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("el servicio deberia responder con un estado HTTP 200 OK")
    public void elServicioDeberiaResponderConUnCodigoDeEstadoHTTPOk() {
        try {
            RestAssured.given().then().statusCode(HttpStatus.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("deberia visualizar su id y token asignado")
    public void deberiaVisualizarSuIdYTokenAsignados() {
        try {
            // Verificar que el token y id no sea nulo
            RestAssured.given().then().body("token", notNullValue());
            RestAssured.given().then().body("id", notNullValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
