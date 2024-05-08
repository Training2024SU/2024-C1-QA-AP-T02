package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
    @Given("Estando en la aplicacion para hacer un login")
    public void estandoEnLaAplicacionParaHacerUnLogin() {
    }

    @When("Hel usuario ingresa la informacion <email> <password> correcta")
    public void helUsuarioIngresaLaInformacionEmailPasswordCorrecta() {
    }

    @Then("deberia obetner un codigo de validacion {int}")
    public void deberiaObetnerUnCodigoDeValidacion(int arg0) {
    }
}
