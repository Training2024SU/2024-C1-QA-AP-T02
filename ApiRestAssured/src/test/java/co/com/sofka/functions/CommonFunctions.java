package co.com.sofka.functions;

public class CommonFunctions {
    public String cuerpoSolicitudPost(String postEmail, String postContrasena) {
        String cuerpoSolicitud = "{\"email\": \"%s\", \"password\": \"%s\"}";
        return String.format(cuerpoSolicitud, postEmail, postContrasena);
    }

    public String requestBodyPosts(String postTitle, String postBody) {
        String requestBodyBase = "{\"title\": \"%s\", \"body\": \"%s\", \"userId\": 1}";
        String requestBody = String.format(requestBodyBase, postTitle, postBody);
        return requestBody;
    }

    public String obtenerTodoPorId(int id) {
        String baseEndpoint = "/todos?userId=%s";
        String endpoint = String.format(baseEndpoint, id);
        return endpoint;
    }
}
