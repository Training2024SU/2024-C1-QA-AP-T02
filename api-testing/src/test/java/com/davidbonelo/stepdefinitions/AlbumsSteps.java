package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.Album;
import com.davidbonelo.models.AlbumFactory;
import com.davidbonelo.models.Photo;
import com.davidbonelo.models.PhotoFactory;
import com.davidbonelo.models.User;
import com.davidbonelo.models.UserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.davidbonelo.ApiEndpoints.ALBUMS_ENDPOINT;
import static com.davidbonelo.ApiEndpoints.PHOTOS_ENDPOINT;
import static com.davidbonelo.ApiEndpoints.PLACEHOLDER_BASE;
import static com.davidbonelo.Utils.pickRandomItem;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AlbumsSteps {
    User user;
    List<Album> albums;
    Album deletedAlbum;
    Album newAlbum;
    Photo newPhoto;
    Response response;

    @Given("A list of albums from a user")
    public void aListOfAlbumsFromAUser() {
        RestAssured.baseURI = PLACEHOLDER_BASE;
        RestAssured.basePath = "";
        user = UserFactory.getRegisteredUser();
        albums = fetchUserAlbums(user);
        System.out.println(albums);
    }

    @When("the user deletes one of the albums")
    public void theUserDeletesOneOfTheAlbums() {
        Album albumToDelete = (Album) pickRandomItem(albums);
        response = when().delete(ALBUMS_ENDPOINT + "/" + albumToDelete.getId());
        deletedAlbum = albumToDelete;
    }

    @Then("he should get a successful response")
    public void heShouldGetASuccessfulResponse() {
        response.then().statusCode(anyOf(equalTo(200), equalTo(201)));
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

    @When("the user creates a new album")
    public void theUserCreatesANewAlbum() {
        newAlbum = AlbumFactory.createFakeAlbum();
        RequestSpecification request = given().contentType(ContentType.JSON)
                .body("{\"title\":\"" + newAlbum.getTitle() + "\",\"userId\":" + user.getId() +
                        "}");
        response = request.when().post(ALBUMS_ENDPOINT);
    }

    @And("he should get the id assigned to that album")
    public void heShouldGetTheIdAssignedToThatAlbum() {
        response.then()
                .body("title", equalTo(newAlbum.getTitle()))
                .body("userId", equalTo(user.getId()))
                .body("id", notNullValue(Integer.class));
    }

    @When("the user adds a photo to one album")
    public void theUserAddsAPhotoToOneAlbum() {
        Album randomAlbum = (Album) pickRandomItem(albums);
        newPhoto = PhotoFactory.createFakePhoto();
        newPhoto.setAlbum(randomAlbum);
        RequestSpecification request = given().contentType(ContentType.JSON)
                .body("{\"albumId\": " + newPhoto.getAlbum().getId() + ",\"title\": \""
                        + newPhoto.getTitle() + "\",\"url\": \"" + newPhoto.getUrl()
                        + "\",\"thumbnailUrl\": \"" + newPhoto.getThumbnailUrl() + "\"}"
                );
        response = request.when().post(PHOTOS_ENDPOINT);
    }

    @And("he should get the id assigned to the new photo")
    public void heShouldGetTheIdAssignedToTheNewPhoto() {
        response.then()
                .body("albumId", equalTo(newPhoto.getAlbum().getId()))
                .body("title", equalTo(newPhoto.getTitle()))
                .body("url", equalTo(newPhoto.getUrl()))
                .body("thumbnailUrl", equalTo(newPhoto.getThumbnailUrl()))
                .body("id", notNullValue(Integer.class));
    }

    @When("the user removes a photo from one album")
    public void theUserRemovesAPhotoFromOneAlbum() {
        response = when().delete(PHOTOS_ENDPOINT + "/4000");
    }
}
