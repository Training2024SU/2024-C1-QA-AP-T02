package co.com.sofkau.stepdefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;


public class ActualizarUsuarioStepDefinition {
    private String userId;
    private Response response;

    @Given("que el usuario con ID {int} usuario requiere actualizar su informacion")
    public void queElUsuarioRequiereActualizarSuInformacion(int userId) {
        this.userId = String.valueOf(userId);
    }

    @When("solicita el servicio de editar la informacion de un usuario")
    public void solicitaElServicioDeEditarLaInformacionDeUnUsuario() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"Andreina\",\n" +
                        "    \"body\": \"bar\",\n" +
                        "    \"userId\": 1\n" +
                        "}")
                .put("https://jsonplaceholder.typicode.com/posts/" + userId);
    }

    @Then("deberia visualizar que el servicio responde con un codigo de estado HTTP 200 OK")
    public void deberiaVisualizarQueElServicioRespondeConUnCodigoDeEstadoHTTPOK() {
        response.then().statusCode(HttpStatus.SC_OK);
    }

}
