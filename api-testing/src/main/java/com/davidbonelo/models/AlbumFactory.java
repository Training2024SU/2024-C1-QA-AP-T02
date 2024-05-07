package com.davidbonelo.models;

import io.restassured.path.json.JsonPath;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class AlbumFactory {
    public static List<Album> getAlbumListFromResponse(String jsonString) {
        List<Album> albums = new ArrayList<>();
        List<LinkedHashMap<String, Object>> albumsJsonList = JsonPath.from(jsonString).getList("");
        for (LinkedHashMap<String, Object> albumJson : albumsJsonList) {
            albums.add(buildAlbumFromJson(albumJson));
        }
        return albums;
    }

    public static Album buildAlbumFromJson(LinkedHashMap<String, Object> albumJson) {
        Integer userId = (Integer) albumJson.get("userId");
        User user = new User();
        user.setId(userId);
        Integer id = (Integer) albumJson.get("id");
        String title = (String) albumJson.get("title");
        return new Album(user, id, title);
    }

    public static Album createFakeAlbum(){
        Faker faker = new Faker(new Locale("es"));
        Album album = new Album();
        album.setTitle(faker.funnyName().name());
        return album;
    }
}
