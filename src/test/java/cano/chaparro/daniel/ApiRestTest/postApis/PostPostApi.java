package cano.chaparro.daniel.ApiRestTest.postApis;

import cano.chaparro.daniel.models.Post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static cano.chaparro.daniel.util.jsonparser.PostParser.postToJson;
import static io.restassured.RestAssured.given;

public class PostPostApi {

    private Post post;
    private Response response;

    public PostPostApi(Post post) {
        this.post = post;
    }

    public void setPostRequest(){

        // Hacer la solicitud POST con Rest-Assured
        Response res =  given()
                .contentType(ContentType.JSON)
                .body(postToJson(post))
                .post("https://jsonplaceholder.typicode.com/posts");

        response = res;

    }

    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        return response.asString();
    }
}
