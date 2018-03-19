package user_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import parsing_json.ElementCollection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserCollectionInitializer {

    public static UserCollection generate() {

        BufferedReader reader = null;
        UserCollection userCollection;
        try {
            reader = new BufferedReader(new FileReader("/Users/brianhe/Dev/Assessments/JavaAssessment3/src/main/resources/users.json"));
            Gson gson = new GsonBuilder().create();
            userCollection = gson.fromJson(reader, UserCollection.class);
            return userCollection;
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
        return new UserCollection();
    }
}
