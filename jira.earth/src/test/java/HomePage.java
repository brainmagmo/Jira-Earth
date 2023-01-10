import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.navigate().to("https://invenauto.tech/index.php");
	}

}
