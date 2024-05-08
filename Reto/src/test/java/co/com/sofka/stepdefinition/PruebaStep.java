package co.com.sofka.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PruebaStep {
    private Response response;


    @Given("Estando el usuario en la seccion de obtener un usuario")
    public void estandoElUsuarioEnLaSeccionDeObtenerUnUsuario() {

        RestAssured.baseURI = "https://reqres.in";

    }

    @When("Se hace la solicitud de encontrar un usuario")
    public void seHaceLaSolicitudDeEncontrarUnUsuario() {
        String GET_SINGLE_USER = "/api/users/{id}";
        response = given()
                .pathParam("id", 2)
                .when()
                .get(GET_SINGLE_USER);

    }

    @Then("hace la peticion get al servicio con sus id {int}")
    public void haceLaPeticionGetAlServicioConSusId(Integer int1, io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        Map<String, String> usuarioEsperado = userData.get(0);
        System.out.println(userData);
        response.then().assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
        response.then().assertThat().body("data.first_name", equalTo("Janet"));
        response.then().assertThat().body("data.last_name", equalTo("Weaver"));


    }
    @Then("deberia obetner la informacion del usuario")
    public void deberiaObetnerLaInformacionDelUsuario(){

    }


}
