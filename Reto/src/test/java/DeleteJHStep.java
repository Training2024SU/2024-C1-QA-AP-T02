import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteJHStep {
    private Response response;


    @Given("Estoy en la página del API jsonplaceholder")
    public void estoyEnLaPáginaDelAPIJsonplaceholder() {
        RestAssured.baseURI = "https://reqres.in";

    }
    @When("Envío una solicitud DELETE para eliminar el post con ID {int}")
    public void envíoUnaSolicitudDELETEParaEliminarElPostConID(int arg0) {
        String DELETE_USER = "/api/users/{id}";
        response = given()
                .pathParam("id", 2)
                .when()
                .delete(DELETE_USER);

    }



    @Then("Debería recibir un código de respuesta {int}")
    public void deberíaRecibirUnCódigoDeRespuesta(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
