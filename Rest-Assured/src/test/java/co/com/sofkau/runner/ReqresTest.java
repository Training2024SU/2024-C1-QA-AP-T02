package co.com.sofkau.runner;

import co.com.sofkau.setup.SetupReqrest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


public class ReqresTest extends SetupReqrest {
    @Test
    public void postRegistroTest(){
                given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .post("/register")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("token", notNullValue());
    }


    @Test
    public void getUnUsuarioTest(){
                given()
                .get("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }


@Test
    public void deleteUnUsuarioTest(){
        given()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void putRequestTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"Andreina\",\n" +
                        "    \"body\": \"bar\",\n" +
                        "    \"userId\": 1\n" +
                        "}")
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200) // Verifica que el código de estado sea 200 OK
                .extract()
                .response() // Extrae la respuesta de la solicitud
                .prettyPrint(); // Imprime la respuesta JSON en la consola
    }




}
