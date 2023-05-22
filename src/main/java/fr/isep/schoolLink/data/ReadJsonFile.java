package fr.isep.schoolLink.data;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.FileReader;

public class ReadJsonFile {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            // Read the JSON file
            Object obj = parser.parse(new FileReader("C:\\Users\\jbouv\\OneDrive\\Desktop\\Ecole\\ISEP\\Cycle_ingenieur\\A2\\Web Technologies\\Project\\src\\main\\java\\fr\\isep\\schoolLink\\data\\universities.json"));

            // Convert the object to a JSON object
            JSONObject jsonObject = (JSONObject) obj;

            // Get the universities array
            JSONArray universities = (JSONArray) jsonObject.get("universities");

            // Iterate over each university
            for (Object universityObj : universities) {
                JSONObject university = (JSONObject) universityObj;

                // Get the university information
                String name = (String) university.get("name");
                String specialtyDomain = (String) university.get("specialty_domain");
                String country = (String) university.get("country");

                // Print the university information
                System.out.println("Name: " + name);
                System.out.println("Specialty Domain: " + specialtyDomain);
                System.out.println("Country: " + country);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
