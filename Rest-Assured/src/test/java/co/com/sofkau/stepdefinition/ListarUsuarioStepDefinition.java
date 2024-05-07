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
import static org.junit.Assert.assertEquals;


public class ListarUsuarioStepDefinition extends SetupReqrest {
    private Response response;
    private int userId;

    @When("se llama el servicio GET para listar un solo usuario por su id {int}")
    public void seLlamaElServicioListarUnSoloUsuario(int userId) {
        try {
            System.out.println("Request ->");
            this.userId = userId;
            response = RestAssured.given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .log().all()
                    .get("https://reqres.in/api/users/" + userId);

            System.out.println("Response ->");
            response.peek();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("el servicio deberia responder con un codigo de estado HTTP 200 OK")
    public void elSistemaDeberiaResponderConUnCodigoDeEstadoHTTPOK() {
        try {
            RestAssured.given().log().all();
            response.then().statusCode(HttpStatus.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("se deberia visualizar los detalles del usuario correctamente")
    public void seDeberiaVisualizarLosDetallesDelUsuarioCorrectamente() {
        try {
            response.then().body("data.id", equalTo(userId)); // Verifica que el ID sea igual al que se ingrese en el feature
            response.then().body("data", notNullValue()); // Verifica que los detalles del usuario no sean nulos

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

