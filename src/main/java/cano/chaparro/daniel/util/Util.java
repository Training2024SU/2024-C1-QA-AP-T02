package cano.chaparro.daniel.util;

import cano.chaparro.daniel.models.Post;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Util {
    public static JSONObject jsonToObject(String jsonString){
        JSONObject jsonObject = new JSONObject();
    try{
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(jsonString);
    } catch (ParseException e) {
        e.printStackTrace();
    }
        return  jsonObject;
    }


    public static Post crearPost(){
        Post post = new Post();
        post.setBody("quia et suscipit nsuscipit recusandae consequuntur expedita et cum nreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto");
        post.setUserId(2);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");

        return post;
    }

}
