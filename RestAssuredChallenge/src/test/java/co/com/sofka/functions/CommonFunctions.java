package co.com.sofka.functions;

public class CommonFunctions {
    public String requestBodyPosts(String postTitle, String postBody) {
        String requestBodyBase = "{\"title\": \"%s\", \"body\": \"%s\", \"userId\": 1}";
        String requestBody = String.format(requestBodyBase, postTitle, postBody);
        return requestBody;
    }

    public String requestBodyPosts(int id, String postTitle, String postBody) {
        String requestBodyBase = "{\"id\": \"%s\", \"title\": \"%s\", \"body\": \"%s\", \"userId\": 1}";
        String requestBody = String.format(requestBodyBase, id, postTitle, postBody);
        return requestBody;
    }

    public String getPostsById(int id) {
        String endpoint = "/posts/" + id;
        return endpoint;
    }

    public String getAllTodosByUserId(int id) {
        String baseEndpoint = "/todos?userId=%s";
        String endpoint = String.format(baseEndpoint, id);
        return endpoint;
    }

    public String getTodosByUserId(int id) {
        String endpoint = "/todos/" + id;
        return endpoint;
    }

    public String requestBodyTodo(int id, String title, boolean completed) {
        String requestBodyBase = "{\"id\": \"%s\", \"title\": \"%s\", \"completed\": %s}";
        String requestBody = String.format(requestBodyBase, id, title, completed);
        return requestBody;
    }

    public String requestBodyUser(String name, String job) {
        String requestBodyBase = "{\"name\": \"%s\", \"job\": \"%s\"}";
        String requestBody = String.format(requestBodyBase, name, job);
        return requestBody;
    }

    public String getAllUsers() {
        String endpoint = "/users";
        return endpoint;
    }
    public String getUserById(int id) {
        String endpoint = "/users/" + id;
        return endpoint;
    }
    public String requestBodyLogin(String email, String password){
        String requestBodyBase = "{\"email\": \"%s\", \"password\": \"%s\"}";
        String requestBody = String.format(requestBodyBase, email, password);
        return requestBody;
    }
}
