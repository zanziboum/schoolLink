package fr.isep.schoolLink.data;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class ReadJsonFile {
    static String filepath = "C:\\Users\\jbouv\\OneDrive\\Desktop\\Ecole\\ISEP\\Cycle_ingenieur\\A2\\Web Technologies\\Project\\src\\main\\java\\fr\\isep\\schoolLink\\data\\universities.json";
    static int numberOfSchools = 57;
    public static JSONArray readJSONFile(String filePath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;

            return (JSONArray) jsonObject.get("universities");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<String> getUniversityNames(JSONArray universities) {
        List<String> result = new ArrayList<>(numberOfSchools);
        for (int i=0;i<numberOfSchools;i++) {
            JSONObject university = (JSONObject) universities.get(i);
            String name = (String) university.get("name");
            result.add(name);
        }
        result = eraseDuplicates(result);
        System.out.println(result);
        return result;
    }
    public static List<String> getUniversityCountries(JSONArray universities) {
        List<String> result = new ArrayList<>(numberOfSchools);
        for (int i=0;i<numberOfSchools;i++){
            JSONObject university = (JSONObject) universities.get(i);
            String country = (String) university.get("country");
            result.add(country);
        }
        result = eraseDuplicates(result);
        System.out.println(result);
        return result;
    }
    public static List<String> eraseDuplicates(List<String> list){
        return list.stream().distinct().toList();
   }
    public static List<String> getUniversitySpecialtyDomain(JSONArray universities) {
        List<String> result = new ArrayList<>(numberOfSchools);
        for (int i=0;i<numberOfSchools;i++){
            JSONObject university = (JSONObject) universities.get(i);
            String specialtyDomain = (String) university.get("specialty_domain");
            result.add(specialtyDomain);
        }
        result = eraseDuplicates(result);
        System.out.println(result);
        return result;
    }
}
