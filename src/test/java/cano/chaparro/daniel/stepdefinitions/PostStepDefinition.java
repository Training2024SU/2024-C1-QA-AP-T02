package cano.chaparro.daniel.stepdefinitions;

import cano.chaparro.daniel.ApiRestTest.postApis.PostPostApi;
import cano.chaparro.daniel.models.Post;
import cano.chaparro.daniel.models.User;
import cano.chaparro.daniel.util.Util;
import cano.chaparro.daniel.util.jsonparser.PostParser;
import cano.chaparro.daniel.util.jsonparser.UserParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

public class PostStepDefinition {

    Post post;

    PostPostApi postApi;

    @Given("que el usuario esta autenticado en el aplicativo web")
    public void queElUsuarioEstaAutenticadoEnElAplicativoWeb() {
        System.out.println("Usuario autenticado");
    }
    @When("se hace una solicitud Post para agregar un nuevo post")
    public void elUsuarioEscribeUnNuevoPost() {
        try{
            post = Util.crearPost();
            postApi = new PostPostApi(post);
            postApi.setPostRequest();
            System.out.println("Se realiza solicitud Post");
        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    @Then("el código de respuesta de estado debería ser {int}")
    public void deberíaVerUnMensajeDeConfirmaciónDeQueElPostFueAgregadoCorrectamente(int codRes) {
        try{
            System.out.println("Se valida código de respuesta ");
            Assertions.assertEquals(codRes,postApi.getStatusCode(),"Se valida código de respuesta 200");

        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("la respuesta debería incluir y validar la información del post creado")
    public void deberiaIncluirYValidarPostCreado() {
        try{
            // JSONObject de la libreria json.simple con la informacion del post
            JSONObject postObject = Util.jsonToObject(postApi.responseToString());

            // parsear objeto Json al tipo post
            Post postResponse = PostParser.toPost(postObject);

            System.out.println("Validar que el post fue creado por el usuario correcto");
            // validar que el body de la respuesta corresponda al usuario indicado
            Assertions.assertEquals(post.getUserId(),postResponse.getUserId());

            System.out.println("Validar que ninguno de los campos del post sea null");
            // Validar que ninguno de los campos del post sea null
            Assertions.assertNotNull(post.getTitle(), "El campo 'title' no debería ser nulo");
            Assertions.assertNotNull(post.getBody(), "El campo 'body' no debería ser nulo");
            Assertions.assertNotNull(post.getUserId(), "El campo 'userId' no debería ser nulo");
            Assertions.assertNotNull(post.getId(), "El campo 'id' no debería ser nulo");

            System.out.println("Valida que el post enviado en la petición corresponda con el creado");
            // Comparar el objeto enviado con el objeto de la respuesta
            Assertions.assertEquals(post.getTitle(), postResponse.getTitle());
            Assertions.assertEquals(post.getBody(), postResponse.getBody());
            Assertions.assertEquals(post.getUserId(), postResponse.getUserId());

        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }


}
