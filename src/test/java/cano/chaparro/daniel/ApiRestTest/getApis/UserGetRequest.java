package cano.chaparro.daniel.ApiRestTest.getApis;
import io.restassured.response.Response;

import static cano.chaparro.daniel.ApiRestTest.PathsApis.USERS_URL;
import static io.restassured.RestAssured.*;


public class UserGetRequest {

    private Response response;
    private int idUser;

    public UserGetRequest(int idUser) {
        this.idUser = idUser;
    }

    public void setGetRequest(){

        Response res = given()
                .when()
                .get(USERS_URL+idUser)
                .then()
                .extract()
                .response();

        response = res;


        // Print the JSON content of the response
//        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 200.
//
//        response.then().statusCode(200); // validate that the response has a status code of 200.
//        // Validate a specific field value in the response
//        response.then().body("userId", equalTo(1));
//        response.then().body("id", equalTo(1));
//        response.then().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
//        response.then().body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }


    public int getStatusCode(){
        return response.then().extract().statusCode();
    }

    public String responseToString(){
        System.out.println(response.asString());
        return response.asString();
    }

}
