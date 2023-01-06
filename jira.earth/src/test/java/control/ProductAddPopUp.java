package control;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;

public class ProductAddPopUp extends Control {
	@FindBy(css="#layer_cart a")
	private WebElement checkoutLink;

	public ProductAddPopUp(WebElement element) {
		super(element);
	}
	
	public CheckoutPage clickProceedToCheckout() {
		checkoutLink.click();
		return new CheckoutPage(((WrapsDriver)element).getWrappedDriver());
	}

}
