package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.sofka.constant.Constants.SIZE;
import static co.com.sofka.constant.Urls.URL_JSONPLACEHOLDER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListarUsuarioStepDefinition extends CommonFunctions {
    Response response;
    String cuerpoSolicitud;

    @Given("un usuario administrador en la pagina web de jsonplaceholder")
    public void unUsuarioAdministradorEnLaPaginaWebDeJsonplaceholder() {
        RestAssured.baseURI = URL_JSONPLACEHOLDER;
    }

    @Given("consulta por userId {int}")
    public void ConsultaPorUserId(Integer userId) {
        cuerpoSolicitud = obtenerTodoPorId(userId);
    }

    @When("envía la solicitud todos los usuarios")
    public void envíaLaSolicitudTodosLosUsuarios() {
        response = given().get(cuerpoSolicitud);
    }

    @Then("la cantidad de todos debe ser {int}")
    public void laCantidadDeTodosDebeSer(Integer todosAmount) {
        response.then().log().all().assertThat().body(SIZE,equalTo(todosAmount));
    }
}
