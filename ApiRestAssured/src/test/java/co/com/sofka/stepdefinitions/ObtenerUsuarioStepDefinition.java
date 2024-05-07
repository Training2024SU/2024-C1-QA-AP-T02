package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static co.com.sofka.constant.Constants.*;
import static co.com.sofka.constant.Urls.URL_REQRES;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerUsuarioStepDefinition {
    Response response;
    RequestSpecification request;

    @Given("el usuario se encuentra en la pagina de perfil")
    public void elUsuarioSeEncuentraEnLaPaginaDePerfil() {
        RestAssured.baseURI = URL_REQRES;
        request = RestAssured.given();
    }
    @When("se pide al servicio la informacion por su id {string}")
    public void sePideAlServicioLaInformacionPorSuId(String id) {
        response = given().
                contentType(ContentType.JSON).
                when().
                get(GET_USER + id)
        ;
        System.out.println("Enlace de la solicitud: "+GET_USER+id);
    }
    @Then("deberia recibir una respuesta con el codigo {int}")
    public void deberiaRecibirUnaRespuestaConElCodigo(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println("codido de respuesta: "+statusCode);
    }
    @Then("deberia recibir la informacion del usuario {string}")
    public void deberiaRecibirLaInformacionDelUsuario(String id) {
        String jsonString = response.asString();
        Integer idd = JsonPath.from(jsonString).get("data.id");
        System.out.println("id: "+idd);
        response.then().log().all().assertThat().body("data.id", equalTo(Integer.parseInt(id)));
    }
}
