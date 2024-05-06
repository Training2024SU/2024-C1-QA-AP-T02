package co.com.sofka.tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonPlaceholderApiTest {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetSinglePost() {
// Realizar la solicitud GET al recurso /posts/1
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/1");

// Verificar el código de estado de la respuesta
        assertEquals(200, response.getStatusCode());

// Verificar el tipo de contenido de la respuesta
        assertEquals("application/json; charset=utf-8", response.getContentType());

// Verificar el contenido de la respuesta
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("\"userId\": 1"));
        assertTrue(responseBody.contains("\"id\": 1"));
        assertTrue(responseBody.contains("\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\""));
        assertTrue(responseBody.contains("\"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\""));

        System.out.println(responseBody);

    }
        }
