package co.com.sofka.stepdefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import io.cucumber.java.en.Given;

public class ObtenerStep {
    private Response response;

    @Given("Estoy en la sección de obtener un post específico")
    public void estoyEnLaSecciónDeObtenerUnPostEspecífico() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("Hago la solicitud para obtener el post con ID {int}")
    public void hagoLaSolicitudParaObtenerElPostConID(Integer id) {
        String GET_POST_ENDPOINT = "/posts/" + id;
        response = given().when().get(GET_POST_ENDPOINT);
    }

    @Then("Debería recibir el post con ID {int} y sus detalles")
    public void deberíaRecibirElPostConIDYSusDetalles(Integer id, DataTable dataTable) {
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("userId", equalTo(1));
        response.then().assertThat().body("id", equalTo(id));
        response.then().assertThat().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        response.then().assertThat().body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

    }
}
