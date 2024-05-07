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
    @When("hace una solicitud GET para buscar el usuario con {int}")
    public void haceUnaSolicitudGetAlUsuarioConID(Integer userId) {
        System.out.println("Se realiza solicitud get al API users");
        userGetRequest = new UserGetRequest(userId);
        userGetRequest.setGetRequest();
    }



    @Then("la respuesta debería tener el código de estado {int}")
    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer response) {
            try{
                System.out.println("Se valida código de respuesta 200");
                Assertions.assertEquals(response,userGetRequest.getStatusCode(),"Se valida código de respuesta 200");
            }catch (Exception e){
                System.out.println();
                System.out.println(e.getMessage());
            }
    }

    @Then("la respuesta debería incluir la información del usuario con ID {int}")
    public void laRespuestaDeberíaIncluirLaInformaciónDelUsuarioConID(Integer userId) {
        try{
            // Valida empty
            System.out.println("Se valida que el body no este vacio");
            Assertions.assertFalse(userGetRequest.responseToString().isEmpty());

            // JSONObject de la libreria json.simple con la informacion del usuario
            JSONObject userObject = Util.jsonToObject(userGetRequest.responseToString());

            // parsear objeto Json al tipo usuario
                User user = UserParser.toUser(userObject);

            System.out.println("Se valida respuesta para el usuario con Id: "+userId);
            // validar que el body de la respuesta corresponda al usuario indicado
            Assertions.assertEquals(userId,user.getId());

            System.out.println("Se valida que ningún campo del objeto user sea null");
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
