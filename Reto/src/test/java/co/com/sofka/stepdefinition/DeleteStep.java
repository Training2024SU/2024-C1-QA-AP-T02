package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteStep {
    private Response response;

    @Given("Estando el usuario en la sección de eliminar un usuario")
    public void estando_el_usuario_en_la_sección_de_eliminar_un_usuario() {
        RestAssured.baseURI = "https://reqres.in";

    }
    @When("Se hace la solicitud para eliminar el usuario con id {int}")
    public void se_hace_la_solicitud_para_eliminar_el_usuario_con_id(Integer int1) {
        String DELETE_USER = "/api/users/{id}";
        response = given()
                .pathParam("id", 2)
                .when()
                .delete(DELETE_USER);

    }
    @Then("se debe recibir una respuesta exitosa con status code {int}")
    public void se_debe_recibir_una_respuesta_exitosa_con_status_code(Integer int1) {
        response.then().assertThat().statusCode(204);

    }
    @Then("el usuario con id {int} debe haber sido eliminado")
    public void el_usuario_con_id_debe_haber_sido_eliminado(Integer int1) {

    }
}
