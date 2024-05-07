package co.com.sofka.stepdefinitions;

import co.com.sofka.model.PostModel;
import co.com.sofka.util.SetModelData;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class UpdatePostStepDefinition extends Setup{

    @When("the user updates the post with id {int} with the following data")
    public void theUserUpdatesThePostWithIdWithTheFollowingData(Integer postId, DataTable dataTable) {
        String UPDATE_URL = "/posts/{id}";

        List<Map<String, String>> postData = dataTable.asMaps(String.class, String.class);
        PostModel postModel = SetModelData.mapPostModelData(postData);

        Gson gson = new Gson();
        String json = gson.toJson(postModel);

        response = request
                .header("Content-Type", "application/json")
                .pathParam("id", postId)
                .when()
                .body(json)
                .put(UPDATE_URL);
    }
}
