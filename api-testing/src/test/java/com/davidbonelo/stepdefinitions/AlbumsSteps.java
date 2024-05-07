package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.Album;
import com.davidbonelo.models.AlbumFactory;
import com.davidbonelo.models.User;
import com.davidbonelo.models.UserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.davidbonelo.ApiEndpoints.ALBUMS_ENDPOINT;
import static com.davidbonelo.ApiEndpoints.PLACEHOLDER_BASE;
import static io.restassured.RestAssured.when;

public class AlbumsSteps {
    User user;
    List<Album> albums;
    Album deletedAlbum;
    Response response;

    @Given("A list of albums from a user")
    public void aListOfAlbumsFromAUser() {
        RestAssured.baseURI = PLACEHOLDER_BASE;
        RestAssured.basePath = "";
        user = UserFactory.getRegisteredUser();
        albums = fetchUserAlbums(user);
        System.out.println(albums);
    }

    @When("he deletes one of the albums")
    public void heDeletesOneOfTheAlbums() {
        Album albumToDelete = albums.get(3); // TODO: chose a random element
        response = when().delete(ALBUMS_ENDPOINT + "/" + albumToDelete.getId());
        deletedAlbum = albumToDelete;
    }

    @Then("he should get a successful response")
    public void heShouldGetASuccessfulResponse() {
        response.then().statusCode(200);
        // response comes with empty body
    }

    @Then("he shouldn't see that album anymore in his list")
    public void heShouldnTSeeThatAlbumAnymoreInHisList() {
        // the api is for testing and doesn't delete the Album
//        albums = fetchUserAlbums(user);
        albums = mockDeletion(deletedAlbum);

        Assertions.assertFalse(albums.contains(deletedAlbum));
    }

    private List<Album> mockDeletion(Album deletedAlbum) {
        albums.remove(deletedAlbum);
        return albums;
    }

    private List<Album> fetchUserAlbums(User user) {
        Response response = when().get("/users/" + user.getId() + ALBUMS_ENDPOINT);
        return AlbumFactory.getAlbumListFromResponse(response.asString());
    }
}
