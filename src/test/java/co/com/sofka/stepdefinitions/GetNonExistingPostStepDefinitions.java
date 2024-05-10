package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNonExistingPostStepDefinitions {

    private Response response;

    @Given("Estoy autenticado como usuario")
    public void estoyAutenticadoComoUsuario(){}

    @When("solicito detalles de un post que no existe")
    public void solicitoDetallesDeUnPostQueNoExiste() {
        response = RestAssured.given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1000"); // ID de un post inexistente
        System.out.println(RestAssured.given());
    }


    @Then("el codigo de estado de la respuesta deberia ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDeberiaSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("El codigo de estado de la respuesta es el esperado : "+ expectedStatusCode);
    }
}

