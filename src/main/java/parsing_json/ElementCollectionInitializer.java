package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ElementCollectionInitializer {

    public static ElementCollection generate() {

        BufferedReader reader = null;
        ElementCollection elementCollection;
        try {
            reader = new BufferedReader(new FileReader("/Users/brianhe/Dev/Assessments/JavaAssessment3/src/main/resources/periodic_table.json"));
            Gson gson = new GsonBuilder().create();
            elementCollection = gson.fromJson(reader, ElementCollection.class);
            return elementCollection;
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
        return new ElementCollection();
    }

}
