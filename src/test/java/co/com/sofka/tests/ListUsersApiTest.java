package co.com.sofka.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListUsersApiTest {

    @Test
    public void testListUsersApi() {
        Response response = getUsers();
        validateResponse(response);
    }

    private Response getUsers() {
        return RestAssured.get("https://reqres.in/api/users?page=1");
    }

    private void validateResponse(Response response) {
        assertStatusCode(response, 200);
        assertContentType(response, "application/json; charset=utf-8");

        assertFieldValue(response, "page", 1);
        assertFieldValue(response, "per_page", 6);
        assertFieldValue(response, "total", 12);
        assertFieldValue(response, "total_pages", 2);
        assertDataSize(response, 6);
    }

    private void assertStatusCode(Response response, int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode(), "El código de estado no coincide");
    }

    private void assertContentType(Response response, String expectedContentType) {
        assertEquals(expectedContentType, response.getContentType(), "El tipo de contenido no coincide");
    }

    private void assertFieldValue(Response response, String fieldName, int expectedValue) {
        assertEquals(expectedValue, response.jsonPath().getInt(fieldName), "El campo '" + fieldName + "' no coincide");
    }

    private void assertDataSize(Response response, int expectedSize) {
        assertEquals(expectedSize, response.jsonPath().getList("data").size(), "El tamaño de los datos no coincide");
    }
}
