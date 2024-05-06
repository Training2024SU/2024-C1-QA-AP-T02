package cano.chaparro.daniel.stepdefinitions;

import cano.chaparro.daniel.ApiRestTest.getApis.UserGetRequest;
import cano.chaparro.daniel.models.User;
import cano.chaparro.daniel.util.Util;
import cano.chaparro.daniel.util.jsonparser.UserParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;


public class UsersStepDefinition {

     UserGetRequest userGetRequest;
    @Given("que el administrador tiene acceso al sistema")
    public void queElAdministradorTieneAccesoALaAPIREST() {
        System.out.println("Acceso concedido");
    }
    @When("se busca al usuario con Id {int}")
    public void haceUnaSolicitudGetAlUsuarioConID(Integer userId) {
        userGetRequest = new UserGetRequest(userId);
        userGetRequest.setGetRequest();
    }
    @Then("la respuesta debería tener el código de estado {int}")
    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer response) {
            try{
                Assertions.assertEquals(response,userGetRequest.getStatusCode());
            }catch (Exception e){
                System.out.println();
                System.out.println(e.getMessage());
            }
    }

    @Then("la respuesta debería incluir la información del usuario con ID {int}")
    public void laRespuestaDeberíaIncluirLaInformaciónDelUsuarioConID(Integer userId) {
        try{
            // JSONObject de la libreria json.simple con la informacion del usuario
            JSONObject userObject = Util.jsonToObject(userGetRequest.responseToString());

            // parsear objeto Json al tipo usuario
                User user = UserParser.toUser(userObject);

            // validar que el body de la respuesta corresponda al usuario indicado
            Assertions.assertEquals(userId,user.getId());

            // Validar que que ninguno de los campos del usuario sea null
            Assertions.assertNotNull(user.getId(), "El campo 'id' no debería ser nulo");
            Assertions.assertNotNull(user.getName(), "El campo 'name' no debería ser nulo");
            Assertions.assertNotNull(user.getUsername(), "El campo 'username' no debería ser nulo");
            Assertions.assertNotNull(user.getEmail(), "El campo 'email' no debería ser nulo");
            Assertions.assertNotNull(user.getPhone(), "El campo 'phone' no debería ser nulo");
            Assertions.assertNotNull(user.getWebsite(), "El campo 'website' no debería ser nulo");

        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

}
