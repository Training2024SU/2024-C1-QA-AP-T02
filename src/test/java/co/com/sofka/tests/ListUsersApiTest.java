package co.com.sofka.tests;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListUsersApiTest {

    private static final String BASE_URL = "https://reqres.in/api/users";

    public static void main(String[] args) {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir el cuerpo de la respuesta
            System.out.println("Response Body: " + response.toString());

            // Analizar el JSON con Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());

            // Extraer el número total de usuarios
            int totalUsers = rootNode.get("total").asInt();
            System.out.println("Total Users: " + totalUsers);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
