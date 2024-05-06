package co.com.sofka.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleUserApiTest {

    private static final String BASE_URL = "https://reqres.in";
    private static final String SINGLE_USER_ENDPOINT = "/api/users/";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetSingleUserById() {
        int userId = 1;

        Response response = getSingleUserResponse(userId);

        assertEquals(200, response.getStatusCode());
        assertUserDataPresent(response);
    }

    @Test
    public void testGetNonExistentUser() {
        int userId = 100; // ID de usuario inválido

        Response response = getSingleUserResponse(userId);

        assertEquals(404, response.getStatusCode());
        assertErrorMessagePresent(response);
    }

    private Response getSingleUserResponse(int userId) {
        return given()
                .when()
                .get(SINGLE_USER_ENDPOINT + userId)
                .then()
                .extract()
                .response();
    }

    private void assertUserDataPresent(Response response) {
        assertTrue(response.getBody().asString().contains("data"));
        assertTrue(response.getBody().asString().contains("id"));
        assertTrue(response.getBody().asString().contains("email"));
        assertTrue(response.getBody().asString().contains("first_name"));
        assertTrue(response.getBody().asString().contains("last_name"));
    }

    private void assertErrorMessagePresent(Response response) {
        assertTrue(response.getBody().asString().contains("error"));
    }
}
