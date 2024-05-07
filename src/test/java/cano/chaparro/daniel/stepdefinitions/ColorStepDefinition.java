package cano.chaparro.daniel.stepdefinitions;

import cano.chaparro.daniel.ApiRestTest.PutApis.ColorPutApi;
import cano.chaparro.daniel.ApiRestTest.deleteApis.DeleteColorApi;
import cano.chaparro.daniel.ApiRestTest.postApis.PostPostApi;
import cano.chaparro.daniel.models.Color;
import cano.chaparro.daniel.models.Post;
import cano.chaparro.daniel.util.Util;
import cano.chaparro.daniel.util.jsonparser.ColorParser;
import cano.chaparro.daniel.util.jsonparser.PostParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

public class ColorStepDefinition {

    Color colorcrete;

    ColorPutApi putColor;

    DeleteColorApi deleteColor;

    @Given("que el usuario esta autenticado en el aplicativo")
    public void queElUsuarioEstaAutenticadoEnElAplicativoWeb() {
        System.out.println("Usuario autenticado");
    }

    @When("el usuario realiza una solicitud PUT para actualizar el color con nombre {string}")
    public void elUsuarioActualizaUnNuevoColorConNombreAñoColorYValorPantone(String nombre) {
        try {
            colorcrete = new Color();
            colorcrete.setName(nombre);

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }

    @When("actualiza los campos a año {int}, color {string} y valor Pantone {string}")
    public void actualizaLosCamposAAñoColorYValorPantone(Integer ano, String color, String pantone) {
        try {
            colorcrete.setId(1);
            colorcrete.setYear(ano);
            colorcrete.setColor(color);
            colorcrete.setPantoneValue(pantone);

            putColor = new ColorPutApi(colorcrete);
            putColor.setColorRequest();
            System.out.println("Se realiza una solicitud put");
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("debería tener la respuesta el código de estado {int}")
    public void deberíaTenerLaRespuestaElCódigoDeEstado(Integer codRes) {
        try {
            System.out.println("Se valida código de respuesta ");
            Assertions.assertEquals(codRes, putColor.getStatusCode(), "Se valida código de respuesta 200");
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }

    @Then("se debería mostrar un mensaje con la informacion del color correctamente actualizada")
    public void seDeberíaMostrarUnMensajeConLaInformacionDelColorCorrectamenteActualizada() {
        try {
            // JSONObject de la libreria json.simple con la información del color
            JSONObject colorObject = Util.jsonToObject(putColor.responseToString());

            // Parsear objeto JSON al tipo Color
            Color colorResponse = ColorParser.toColor(colorObject);

            // Validar que el color tiene el mismo ID que el color indicado
            System.out.println("Se valida color a actualizar");
            Assertions.assertEquals(colorcrete.getId(), colorResponse.getId());

            System.out.println("Validar que ninguno de los campos del color actualizado sea null");
            // Validar que ninguno de los campos del color sea null
            Assertions.assertNotNull(colorResponse.getName(), "El campo 'name' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getYear(), "El campo 'year' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getColor(), "El campo 'color' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getPantoneValue(), "El campo 'pantoneValue' no debería ser nulo");

            System.out.println("Validar campos del color actualizado");
            // Comparar el objeto enviado con el objeto de la respuesta
            Assertions.assertEquals(colorcrete.getName(), colorResponse.getName());
            Assertions.assertEquals(colorcrete.getYear(), colorResponse.getYear());
            Assertions.assertEquals(colorcrete.getColor(), colorResponse.getColor());
            Assertions.assertEquals(colorcrete.getPantoneValue(), colorResponse.getPantoneValue());
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }


    @When("el usuario realiza una solicitud DELETE para eliminar el color con ID {int}")
    public void elUsuarioRealizaUnaSolicitudDELETEParaEliminarElColorConID(Integer colorId) {
        try {
            deleteColor = new DeleteColorApi(colorId);
            deleteColor.setColorRequest();
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("la respuesta debería tener un codigo de estado {int}")
    public void laRespuestaDeberíaTenerUnCodigoDeEstado(Integer codEst) {
        try {
            System.out.println("Se valida código de respuesta ");
            Assertions.assertEquals(codEst,deleteColor.getStatusCode());
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    @Then("el cuerpo de la respuesta debería estar vacío")
    public void elCuerpoDeLaRespuestaDeberíaEstarVacío() {
        try {

            System.out.println("Se valida body vacio indicando un delete exitoso");
            Assertions.assertTrue(deleteColor.responseToString().isEmpty());
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }


}
