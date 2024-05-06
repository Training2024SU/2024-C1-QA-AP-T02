package cano.chaparro.daniel.ApiRestTest.PutApis;

import cano.chaparro.daniel.models.Color;
import cano.chaparro.daniel.models.Post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static cano.chaparro.daniel.ApiRestTest.PathsApis.PUT_COLOR;
import static cano.chaparro.daniel.util.jsonparser.ColorParser.colorToJson;
import static cano.chaparro.daniel.util.jsonparser.PostParser.postToJson;
import static io.restassured.RestAssured.given;

public class ColorPutApi {
    private Color color;
    private Response response;

    public ColorPutApi(Color color) {
        this.color = color;
    }

    public void setColorRequest(){

        // Hacer la solicitud POST con Rest-Assured
        Response res =  given()
                .contentType(ContentType.JSON)
                .body(colorToJson(color))
                .put(PUT_COLOR+color.getId());
        response = res;

    }

    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        return response.asString();
    }
}
