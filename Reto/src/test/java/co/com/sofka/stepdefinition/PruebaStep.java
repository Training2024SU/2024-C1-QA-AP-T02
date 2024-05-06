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


    @Given("Se hace la solicitud de encontrar un usuario")
    public void SeHaceLaSolicitudDeEncontrarUnUsuario() {
        RestAssured.baseURI = "https://reqres.in";

    }

    @When("hace la peticion get al servicio con sus credenciales")
    public void haceLaPeticionGetAlServicioConSusCredenciales() {
        String GET_SINGLE_USER = "/api/users/2";
        response = given()
                .when()
                .get(GET_SINGLE_USER);

    }

    @Then("deberia obetner la informacion del usuario")
    public void deberiaObetnerLaInformacionDelUsuario(DataTable dataTable) {

        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        Map<String, String> usuarioEsperado = userData.get(0);
        System.out.println(userData);
        response.then().assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
        response.then().assertThat().body("data.first_name", equalTo("Janet"));
        response.then().assertThat().body("data.last_name", equalTo("Weaver"));

    }
}
