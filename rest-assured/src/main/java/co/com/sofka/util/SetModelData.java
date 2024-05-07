package co.com.sofka.util;

import co.com.sofka.model.PostModel;
import co.com.sofka.model.reqress.UserGetModel;
import co.com.sofka.model.reqress.UserPostModel;

import java.util.List;
import java.util.Map;


public class SetModelData {
    public static UserGetModel mapUserGetModelData(List<Map<String, String>> userModelData) {
        UserGetModel userGetModel = new UserGetModel();
        userModelData.forEach(model -> {
            userGetModel.setId(model.get("id"));
            userGetModel.setEmail(model.get("email"));
            userGetModel.setFirstName(model.get("firstName"));
            userGetModel.setLastName(model.get("lastName"));
        });
        return userGetModel;
    }

    public static UserPostModel mapUserPostModelData(List<Map<String, String>> userModelData) {
        UserPostModel userPostModel = new UserPostModel();
        userModelData.forEach(model -> {
            userPostModel.setName(model.get("name"));
            userPostModel.setJob(model.get("job"));
        });
        return userPostModel;
    }
    public static PostModel mapPostModelData(List<Map<String, String>> postModelData) {
        PostModel postModel = new PostModel();
        postModelData.forEach(model -> {
            postModel.setId(model.get("id"));
            postModel.setBody(model.get("body"));
            postModel.setTitle(model.get("title"));
            postModel.setUserId(model.get("userId"));
        });
        return postModel;
    }
}
