package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends Page {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.route = "index.php?controller=order";
	}

	public boolean areThereProducts() {
		var cssPath = ".cart_navigation";
		var maybeButtons = this.driver.findElements(By.cssSelector(cssPath));
		return maybeButtons.size() > 0;
	}

    public CheckoutPage navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }

}