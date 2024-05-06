package co.com.sofka.util;

import co.com.sofka.model.UserGetModel;
import co.com.sofka.model.UserPostModel;

import java.util.List;
import java.util.Map;


public class SetModelData {
    public static UserGetModel setUserGetModelData(List<Map<String, String>> userModelData) {
        UserGetModel userGetModel = new UserGetModel();
        userModelData.forEach(model -> {
            userGetModel.setId(model.get("id"));
            userGetModel.setEmail(model.get("email"));
            userGetModel.setFirstName(model.get("firstName"));
            userGetModel.setLastName(model.get("lastName"));
        });
        return userGetModel;
    }

    public static UserPostModel setUserPostModelData(List<Map<String, String>> userModelData) {
        UserPostModel userPostModel = new UserPostModel();
        userModelData.forEach(model -> {
            userPostModel.setName(model.get("name"));
            userPostModel.setJob(model.get("job"));
        });
        return userPostModel;
    }
}
