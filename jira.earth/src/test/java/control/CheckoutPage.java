package control;

import org.openqa.selenium.WebDriver;

import page.Page;

public class CheckoutPage extends Page {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.route = "index.php?controller=order";
	}

	public boolean areThereProducts() {
		// TODO Auto-generated method stub
		return false;
	}

}
