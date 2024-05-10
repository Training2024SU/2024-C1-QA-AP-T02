package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatePostStepDefinitions {

    private Response response;
    private String requestBody;
    private int postId;

    @Given("que tengo un objeto de post válido")
    public void queTengoUnObjetoDePostVálido() {
        requestBody = "{ \"title\": \"Nuevo post\", \"body\": \"Contenido del nuevo post\", \"userId\": 1 }";
        System.out.println(requestBody);
    }

    @When("envío una solicitud POST para crear un nuevo post")
    public void envíoUnaSolicitudPOSTParaCrearUnNuevoPost() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        postId = response.then()
                .extract()
                .path("id");
    }

    @Then("el codigo de estado de la respuesta debería ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDeberíaSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
        System.out.println("El codigo de estado de la respuesta es el esperado : "+ expectedStatusCode);

    }

    @Then("el tipo de contenido de la respuesta deberia ser JSON")
    public void elTipoDeContenidoDeLaRespuestaDeberiaSerJSON() {
        assertEquals("application/json; charset=utf-8", response.getContentType());
    }

    @Then("la respuesta debería contener el ID del nuevo post creado")
    public void laRespuestaDeberíaContenerElIDDelNuevoPostCreado() {
        assertNotNull(postId);
    }
}
