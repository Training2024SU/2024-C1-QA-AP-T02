package cano.chaparro.daniel.util.jsonparser;

import cano.chaparro.daniel.models.Color;
import org.json.simple.JSONObject;

public class ColorParser {

    public static String colorToJson(Color color) {
        // Crear un objeto JSONObject
        JSONObject jsonObject = new JSONObject();

        // Agregar los atributos del objeto Color al JSONObject
        jsonObject.put("id", color.getId());
        jsonObject.put("name", color.getName());
        jsonObject.put("year", color.getYear());
        jsonObject.put("color", color.getColor());
        jsonObject.put("pantone_value", color.getPantoneValue());

        // Retornar el JSONObject resultante
        return jsonObject.toJSONString();
    }

    public static Color toColor(JSONObject jsonObject) {
        // Crear un objeto Color
        Color color = new Color();
        color.setId(Integer.parseInt(jsonObject.get("id").toString()));
        color.setName((String) jsonObject.get("name"));
        color.setYear(Integer.parseInt(jsonObject.get("year").toString()));
        color.setColor((String) jsonObject.get("color"));
        color.setPantoneValue((String) jsonObject.get("pantone_value"));
        return color;
    }
}
