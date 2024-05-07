package com.davidbonelo.models;

import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class AlbumFactory {
    public static List<Album> getAlbumListFromResponse(String jsonString) {
        List<Album> albums = new ArrayList<>();
        List<LinkedHashMap<String, Object>> albumsJsonList = JsonPath.from(jsonString).getList("");
        for (LinkedHashMap<String, Object> albumJson : albumsJsonList) {
            System.out.println(albumJson);
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
}
