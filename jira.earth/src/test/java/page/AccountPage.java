package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {
	
	@FindBy(css = "a.account")
	private WebElement accountElement;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.route = "index.php?controller=my-account";
		driver.get(this.getURL());
	}

	public Object getUserName() {
		return accountElement.getText();
	}

}
