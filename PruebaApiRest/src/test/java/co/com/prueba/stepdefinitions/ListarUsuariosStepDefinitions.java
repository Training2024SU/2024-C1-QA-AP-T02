package co.com.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;

import static co.com.prueba.apiUtil.ApiUtils.realizarSolicitud;
import static co.com.prueba.util.ConstantesApi.*;
import static com.google.common.base.Predicates.equalTo;
import static java.nio.file.Files.size;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class ListarUsuariosStepDefinitions {
    private Response response;
    @Dado("que el servicio GET en la pagina jsonplaceholder.typicode está en línea y accesible")
    public void que_el_servicio_get_en_la_pagina_jsonplaceholder_typicode_está_en_línea_y_accesible() {
        RestAssured.baseURI = USER_TYPE_CODE;
    }
    @Cuando("realiza una solicitud GET al endpoint en la pagina")
    public void realiza_una_solicitud_get_al_endpoint_en_la_pagina() {
        realizarSolicitud();
    }
    @Entonces("deberia mostrar un código de estado HTTP {int}")
    public void deberia_mostrar_un_código_de_estado_http(Integer int1) {
        assertEquals(EXPECTED_2,200);
    }

}
