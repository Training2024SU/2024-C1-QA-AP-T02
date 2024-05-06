package cano.chaparro.daniel.stepdefinitions;

import cano.chaparro.daniel.ApiRestTest.PutApis.ColorPutApi;
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

    @Given("que el usuario esta autenticado en el aplicativo")
    public void queElUsuarioEstaAutenticadoEnElAplicativoWeb() {
        System.out.println("Usuario autenticado");
    }

    @When("el usuario actualiza un color con nombre {string}, año {int}, color {string} y valor Pantone {string}")
    public void elUsuarioActualizaUnNuevoColorConNombreAñoColorYValorPantone(String nombre, Integer ano, String color, String pantone) {
        try {
            colorcrete = new Color(2, nombre, ano, color, pantone);
            putColor = new ColorPutApi(colorcrete);
            putColor.setColorRequest();
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

    }

    @Then("debería ver un mensaje de confirmación de que el color fue actualizado correctamente")
    public void deberíaVerUnMensajeDeConfirmaciónDeQueElColorFueActualizadoCorrectamente() {
        try {
            // JSONObject de la libreria json.simple con la información del color
            JSONObject colorObject = Util.jsonToObject(putColor.responseToString());

// Parsear objeto JSON al tipo Color
            Color colorResponse = ColorParser.toColor(colorObject);

// Validar que el color tiene el mismo ID que el color indicado
            Assertions.assertEquals(colorcrete.getId(), colorResponse.getId());

// Validar que ninguno de los campos del color sea null
            Assertions.assertNotNull(colorResponse.getName(), "El campo 'name' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getYear(), "El campo 'year' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getColor(), "El campo 'color' no debería ser nulo");
            Assertions.assertNotNull(colorResponse.getPantoneValue(), "El campo 'pantoneValue' no debería ser nulo");

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


}
