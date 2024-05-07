package co.com.prueba.stepdefinitions;

import co.com.prueba.model.api.DTOUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static co.com.prueba.apiUtil.ApiUtils.crearUsuario;
import static co.com.prueba.util.ConstantesApi.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class crearUsuarioStepDefinitions {
    private Response response;
    @Dado("que el servicio POST está en línea y accesible")
    public void queElServicioPOSTEstáEnLíneaYAccesible() {
        RestAssured.baseURI = REQRES_CREATE_USER;
    }
    @Cuando("realiza una solicitud tipo POST")
    public void realizaUnaSolicitudTipoPOST() {
        crearUsuario();
    }
    @Entonces("deberia devolver un codigo {int} indicando que el usuario fue creado correctamente")
    public void deberiaDevolverUnCodigoIndicandoQueElUsuarioFueCreadoCorrectamente(Integer int1) {
        assertEquals(EXPECTED_1,201);
    }
}
