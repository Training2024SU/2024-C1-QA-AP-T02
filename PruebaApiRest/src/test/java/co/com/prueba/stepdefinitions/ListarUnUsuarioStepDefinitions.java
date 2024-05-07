package co.com.prueba.stepdefinitions;

import co.com.prueba.model.api.DTOUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static co.com.prueba.util.ConstantesApi.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;


public class ListarUnUsuarioStepDefinitions {
    private Response response;
    @Dado("que el servicio GET de usuarios está en línea y accesible")
    public void queElServicioGETDeUsuariosEstáEnLíneaYAccesible() {
        RestAssured.baseURI = REQRES_IN_SINGLE_USER;
    }
    @Cuando("realiza una solicitud GET al endpoint")
    public void realizaUnaSolicitudGETAlEndpoint() {
        response = given().log().all().get();
    }
    @Entonces("deberia devolver un código de estado HTTP {int}")
    public void deberiaDevolverUnCódigoDeEstadoHTTP(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }

    @Entonces("la respuesta con información del usuario con email")
    public void laRespuestaConInformaciónDelUsuarioConEmail() {
        Gson gson = new Gson();
        DTOUsuario dtoUsuario = gson.fromJson(response.getBody().asString(), DTOUsuario.class);
        assertEquals(dtoUsuario.getData().getEmail(),EMAIL_ESPERADO);
    }
}
