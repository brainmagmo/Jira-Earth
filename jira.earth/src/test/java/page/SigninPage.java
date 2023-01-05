package page;

import org.openqa.selenium.WebDriver;

public class SigninPage extends Page {

	public SigninPage(WebDriver driver) {
		super(driver);
		this.route = "index.php?controller=authentication&back=my-account";
		driver.get(this.getURL());
	}

}
