package cano.chaparro.daniel.ApiRestTest.deleteApis;

import cano.chaparro.daniel.models.Color;
import io.restassured.response.Response;

import static cano.chaparro.daniel.ApiRestTest.PathsApis.DELETE_COLOR;
import static io.restassured.RestAssured.given;

public class DeleteColorApi {
    private int colorId;
    private Response response;

    public DeleteColorApi(int color) {
        this.colorId = color;
    }

    public void setColorRequest(){
        // Hacer la solicitud POST con Rest-Assured
        Response res =  given()
                .delete(DELETE_COLOR+colorId);
        response = res;
    }

    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        System.out.println(response.asString());
        return response.asString();
    }
}
