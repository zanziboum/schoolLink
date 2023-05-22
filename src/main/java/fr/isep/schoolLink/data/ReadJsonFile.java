package fr.isep.schoolLink.data;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class ReadJsonFile {
    public static JSONArray readJSONFile(String filePath) {
        JSONParser parser = new JSONParser();

        try {
            // Read the JSON file
            Object obj = parser.parse(new FileReader(filePath));

            // Convert the object to a JSON object
            JSONObject jsonObject = (JSONObject) obj;

            // Get the universities array
            return (JSONArray) jsonObject.get("universities");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getUniversityName(JSONObject university) {
        return (String) university.get("name");
    }

    public static String getUniversitySpecialtyDomain(JSONObject university) {
        return (String) university.get("specialty_domain");
    }

    public static String getUniversityCountry(JSONObject university) {
        return (String) university.get("country");
    }
}
