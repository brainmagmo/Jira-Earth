package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
		this.route = "index.php";
	}
}