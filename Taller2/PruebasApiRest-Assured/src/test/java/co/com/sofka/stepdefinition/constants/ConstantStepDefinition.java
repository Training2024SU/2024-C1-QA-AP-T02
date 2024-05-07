package co.com.sofka.stepdefinition.constants;

public class ConstantStepDefinition {
    public static final String REGRES_POST_SD_ONE = "https://reqres.in";
    public static final String REGRES_POST_SD_TWO = "/api/users";
    public static final String REGRES_POST_SD_THREE = "/api/register";
    public static final String REGRES_POST_SD_ASSERTION_ONE = "name";
    public static final String REGRES_POST_SD_ASSERTION_TWO = "job";

    public static final String REGRES_GET_SD_ONE = "https://reqres.in/";
    public static final String REGRES_GET_SD_TWO = "/api/users/{id}";
    public static final String REGRES_GET_SD_THREE = "id";

    public static final String REGRES_GET_SD_ASSERTION_ONE = "data.id";
    public static final String REGRES_GET_SD_ASSERTION_TWO = "data.email";
    public static final String REGRES_GET_SD_ASSERTION_THREE = "data.first_name";
    public static final String REGRES_GET_SD_ASSERTION_FOUR = "data.last_name";

    public static final String JSON_POST_SD_URL = "https://jsonplaceholder.typicode.com";
    public static final String JSON_POST_SD_ONE = "/posts";

    public static final String JSON_POST_SD_ASSERTION_ONE = "userId";
    public static final String JSON_POST_SD_ASSERTION_TWO = "id";
    public static final String JSON_POST_SD_ASSERTION_THREE = "title";
    public static final String JSON_POST_SD_ASSERTION_FOUR = "body";

    public static final String JSON_GET_SD_ONE = "/posts/{id}";
    public static final String JSON_GET_SD_TWO = "id";

    public static final String JSON_GET_SD_ASSERTION_ONE = "userId";
    public static final String JSON_GET_SD_ASSERTION_TWO = "id";
    public static final String JSON_GET_SD_ASSERTION_THREE = "title";
    public static final String JSON_GET_SD_ASSERTION_FOUR = "body";

    public static final String JSON_CONTENT_TYPE = "Content-Type";
    public static final String JSON_APPLICATION = "application/json";
}
