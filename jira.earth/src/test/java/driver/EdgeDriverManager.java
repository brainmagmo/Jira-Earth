package driver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    final String edgeDriverPath = "C:\\temp\\msedgedriver.exe";

    @Override
    public void createDriver() {
        System.setProperty("webdriver.msedge.driver", edgeDriverPath);
        this.driver = new EdgeDriver();
    }
}