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
    @When("el usuario escribe un nuevo post")
    public void elUsuarioEscribeUnNuevoPost() {
        try{
            post = Util.crearPost();
            postApi = new PostPostApi(post);
            postApi.setPostRequest();
        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    @Then("debería ver un mensaje de confirmación con la informacion de post actualizado")
    public void deberíaVerUnMensajeDeConfirmaciónDeQueElPostFueAgregadoCorrectamente() {
        try{
            // JSONObject de la libreria json.simple con la informacion del post
            JSONObject postObject = Util.jsonToObject(postApi.responseToString());

            // parsear objeto Json al tipo post
            Post postResponse = PostParser.toPost(postObject);

            // validar que el body de la respuesta corresponda al usuario indicado
            Assertions.assertEquals(post.getUserId(),postResponse.getUserId());

            // Validar que ninguno de los campos del post sea null
            Assertions.assertNotNull(post.getTitle(), "El campo 'title' no debería ser nulo");
            Assertions.assertNotNull(post.getBody(), "El campo 'body' no debería ser nulo");
            Assertions.assertNotNull(post.getUserId(), "El campo 'userId' no debería ser nulo");
            Assertions.assertNotNull(post.getId(), "El campo 'id' no debería ser nulo");

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
