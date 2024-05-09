package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteJHStep {
private Response response;

    @Given("Estoy en la página del API jsonplaceholder")
    public void estoyEnLaPáginaDelAPIJsonplaceholder() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @When("Envío una solicitud DELETE para eliminar el post con ID {int}")
    public void envíoUnaSolicitudDELETEParaEliminarElPostConID(Integer id) {
        String DELETE_USER = "/posts/{id}";
        response = given()
                .pathParam("id", id)
                .when()
                .delete(DELETE_USER);
    }
    @Then("Debería recibir un código de respuesta {int}")
    public void deberíaRecibirUnCódigoDeRespuesta(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
