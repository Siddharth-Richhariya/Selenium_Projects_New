package CAWSStudioAssignment;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Utility class for handling JSON file reading and assertions
public class JSONUtils {
    // Reads data from a JSON file and returns it as a string
    public String readDataFromJSON(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();  // JSON parser instance
        FileReader reader = new FileReader(filePath); // Reads the JSON file
        Object obj = parser.parse(reader); // Parses the JSON file
        JSONArray jsonArray = (JSONArray) obj; // Casts parsed object to JSONArray

        return jsonArray.toJSONString(); // Converts JSONArray to String and returns it
    }

    // Compares JSON data with data from the table
    public void assertTable(List<String> tabledata, String JSONData) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(JSONData);
        for(Object obj : jsonArray){
            JSONObject person = (JSONObject) obj;  // Casts each JSON entry to a JSONObject
            String name = (String)  person.get("name"); // Retrieves 'name' value
            String age = String.valueOf(person.get("age")); // Retrieves 'age' value
            String gender = (String) person.get("gender"); // Retrieves 'gender' value

            // Asserts that table data contains each attribute from JSON data
            Assert.assertTrue(tabledata.contains(name),"Name Mismatch: Expected Name: "+name);
            Assert.assertTrue(tabledata.contains(age),"Age Mismatch: Expected Name: "+age);
            Assert.assertTrue(tabledata.contains(gender),"Gender Mismatch: Expected Name: "+gender);
        }
    }


}
