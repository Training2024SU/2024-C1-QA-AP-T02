package co.com.sofka.utils;

import co.com.sofka.model.UserRegresPostModel;
import co.com.sofka.model.JsonPlaceHolderWebPostModel;
import co.com.sofka.model.UserRegresGetModel;

import java.util.List;
import java.util.Map;

public class Utils {

    public static UserRegresPostModel extractUserDetails(Map<String, String> userDetails) {
        UserRegresPostModel userRegresPostModel = new UserRegresPostModel();
        userRegresPostModel.setName(userDetails.get("name"));
        userRegresPostModel.setJob(userDetails.get("job"));
        return userRegresPostModel;
    }

    public static UserRegresGetModel extractUserDetails(List<Map<String, String>> userDetails) {
        UserRegresGetModel userRegresGetModel = new UserRegresGetModel();

        userDetails.forEach(model ->{
            userRegresGetModel.setId(model.get("id"));
            userRegresGetModel.setEmail(model.get("email"));
            userRegresGetModel.setFirstName(model.get("firstName"));
            userRegresGetModel.setLastName(model.get("lastName"));
        });

        return userRegresGetModel;
    }

    public static JsonPlaceHolderWebPostModel extractWebPostDetails(List<Map<String, String>> webPostData) {
        JsonPlaceHolderWebPostModel jsonPlaceHolderGetModel = new JsonPlaceHolderWebPostModel();
        webPostData.forEach(model -> {

            jsonPlaceHolderGetModel.setUserId(model.get("userId"));
            jsonPlaceHolderGetModel.setId(model.get("id"));
            jsonPlaceHolderGetModel.setTitle(model.get("title"));
            jsonPlaceHolderGetModel.setBody(model.get("body"));
        });
        return jsonPlaceHolderGetModel;
    }
}
