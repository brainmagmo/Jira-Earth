package driver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    final String chromeDriverPath = "C:\\temp\\chromedriver.exe";
    
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.driver = new ChromeDriver();
    }
}