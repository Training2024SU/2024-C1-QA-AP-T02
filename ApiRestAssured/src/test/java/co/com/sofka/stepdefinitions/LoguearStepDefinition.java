package co.com.sofka.stepdefinitions;

import co.com.sofka.functions.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static co.com.sofka.constant.Constants.POSTS_LOGIN;
import static co.com.sofka.constant.Constants.TOKEN;
import static co.com.sofka.constant.Urls.URL_REQRES;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoguearStepDefinition extends CommonFunctions {
    Response response;
    String cuerpoSolicitud;

    @Given("el usuario se encuentra en la pagina inicio de sesion")
    public void elUsuarioSeEncuentraEnLaPaginaInicioDeSesion() {
            RestAssured.baseURI = URL_REQRES;
    }
    @When("ingresa su email {string} con la contraseña {string}")
    public void ingresaSuEmailConLaContraseña(String email, String contrasena) {
        cuerpoSolicitud = cuerpoSolicitudPost(email,contrasena);
    }
    @Then("deberia recibir una respuesta con el codigo de estado {int}")
    public void deberiaRecibirUnaRespuestaConElCodigoDeEstado(Integer statusCode) {
        response = given().
                contentType(ContentType.JSON).
                body(cuerpoSolicitud).
                when().
                post(POSTS_LOGIN);
        System.out.println("Cuerpo de la solicitud: "+cuerpoSolicitud);
        response.then().assertThat().statusCode(statusCode);
        System.out.println("codido de respuesta: "+statusCode);
    }
    @Then("deberia recibir un token")
    public void deberiaRecibirUnToken() {
        response.then().log().all().assertThat().body("token", equalTo(TOKEN));
        System.out.println("el token es: "+TOKEN);
    }
}
