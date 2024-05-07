package co.com.sofkau.stepdefinition;

import co.com.sofkau.setup.SetupJsonPlaceholder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.runner.Request;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ActualizarUsuarioStepDefinition extends SetupJsonPlaceholder {
    private Response response;
    private int userId;
    private String title;
    private String body;
    private int id;

    @Given("que el usuario con ID {int} requiere actualizar su informacion titulo {string} cuerpo {string} y userId {int}")
    public void queElUsuarioRequiereActualizarSuInformacion(int id, String title, String body, int userId) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.id = id;
    }

    @When("solicita el servicio PUT para actualizar la informacion del usuario")
    public void solicitaElServicioDeEditarLaInformacionDeUnUsuario() {
        try {
            System.out.println("Request ->");
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"id\":" +  id + ",\n" +
                            "    \"title\": \"" + title + "\",\n" +
                            "    \"body\": \"" + body + "\",\n" +
                            "    \"userId\": " + userId + "\n" +
                            "}")
                    .log().all()
                    .put("https://jsonplaceholder.typicode.com/posts/" + id);

            System.out.println("Response ->");
            response.peek();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("deberia visualizar que el servicio responde con un codigo de estado HTTP 200 OK")
    public void deberiaVisualizarQueElServicioRespondeConUnCodigoDeEstadoHTTPOK() {
        try {
            response.then().statusCode(HttpStatus.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("deberia ver los datos del usuario actualizados, coincidiendo con los cambios realizados")
    public void deberiaVerLosDatosDelUsuarioActualizados() {
        try {
            // Verificar que no haya valores nulos en el mapa
            Map<String, Object> userData = response.jsonPath().getMap("$");
            for (Object value : userData.values()) {
                assertNotNull(value);
            }

            // Verificar que el ID del post se ha actualizado
            assertEquals(id, response.jsonPath().getInt("id"));


            // Verificar que otros atributos del post se han actualizado


            assertEquals(title, response.jsonPath().getString("title"));
            assertEquals(body, response.jsonPath().getString("body"));
            assertEquals(userId, response.jsonPath().getInt("userId"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}