package page;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import test.Config;

public abstract class InvenAutoPage extends Page {
    public InvenAutoPage(WebDriver driver) {
        super(driver);

        try {
            var index =  new Config("options.json").get("index");
            this.index = index;
        }
        catch(FileNotFoundException e) {
            System.err.println("Configuration file does not exist.");
            e.printStackTrace();
        }
    }
}