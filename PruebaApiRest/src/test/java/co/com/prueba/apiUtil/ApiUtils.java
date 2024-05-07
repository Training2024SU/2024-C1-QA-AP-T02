package co.com.prueba.apiUtil;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static co.com.prueba.util.ConstantesApi.*;
import static co.com.prueba.util.ConstantesApi.JOB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ApiUtils {
    public static void crearUsuario(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(VALUE_NAME, NAME);
        map.put(VALUE_JOB, JOB);

        given()
                .log().all()
                .body(map.toString())
                .when()
                .post(REQRES_CREATE_USER)
                .then()
                .log().all()
                .statusCode(201);
    }

    public static void realizarSolicitud() {
        String body = given()
                .when()
                .get(USER_TYPE_CODE)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        System.out.println(body);
    }
    public static void listarAlbum() {
        String body = given()
                .when()
                .get(ALBUM)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        System.out.println(body);
    }

}
