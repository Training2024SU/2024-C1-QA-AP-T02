package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.constant.Constants.POST_CREAR;
import static co.com.sofka.constant.Urls.URL_JSONPLACEHOLDER;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearPostStepDefinition extends CommonFunctions {
    Response response;
    String cuerpoSolicitud;

    @Given("el usuario esta en la pagina web de jsonplaceholder")
    public void elUsuarioEstaEnLaPaginaWebDeJsonplaceholder() {
        RestAssured.baseURI = URL_JSONPLACEHOLDER;
    }

    @When("escribe la informacion para el nuevo correo {string} {string}")
    public void escribeLaInformacionParaElNuevoCorreo(String title, String body) {
        cuerpoSolicitud = requestBodyPosts(title, body);
    }

    @When("envia la solicitud")
    public void enviaLaSolicitud() {
        response = given().
                contentType(ContentType.JSON).
                body(cuerpoSolicitud).
                when().
                post(POST_CREAR);
        System.out.println("Cuerpo de la solicitud: "+cuerpoSolicitud);
    }

    @Then("deberia obtener un codigo de respuesta {int}")
    public void deberiaObtenerUnCodigoDeRespuesta(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println("codido de respuesta: "+statusCode);
    }

    @Then("el titulo debe ser {string}")
    public void elTituloDebeSer(String titulo) {
        response.then().log().all().assertThat().body("title", equalTo(titulo));
        System.out.println("el tititulo es: "+titulo);
    }
}
