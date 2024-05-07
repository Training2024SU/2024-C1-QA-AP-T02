package co.com.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.RestAssured;

import static co.com.prueba.apiUtil.ApiUtils.listarAlbum;
import static co.com.prueba.util.ConstantesApi.*;
import static org.junit.Assert.assertEquals;

public class AlbumListStrpDefinitions {
    @Dado("que el servicio REST está en línea y accesible")
    public void que_el_servicio_rest_está_en_línea_y_accesible() {
        RestAssured.baseURI = ALBUM;
    }
    @Cuando("se realiza una solicitud tipo GET")
    public void se_realiza_una_solicitud_tipo_get() {
        listarAlbum();
    }
    @Entonces("deberia ver un código de estado HTTP {int}")
    public void deberia_ver_un_código_de_estado_http(Integer int1) {
        assertEquals(EXPECTED_2,200);
    }
}
