package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Config {
    private JSONObject options;

    public Config(String filePath) throws FileNotFoundException {
        this.options 
          = new JSONObject (
                new JSONTokener(new FileInputStream(filePath))
            );
    }

    public String get(String option) {
        return options.getString(option);
    }
}