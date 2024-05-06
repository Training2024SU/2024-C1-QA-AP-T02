import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ReqResTests {

    private static String login = "{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"cityslicka\"\n" +
            "}";

    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(login)
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .extract()
                .asString();

        System.out.println(response);
    }
}
