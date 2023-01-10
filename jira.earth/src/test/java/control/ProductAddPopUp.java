package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import page.CheckoutPage;

public class ProductAddPopUp extends Control {

	public ProductAddPopUp(WebElement element) {
		super(element);
	}

	public CheckoutPage clickProceedToCheckout() {
    	WebElement checkoutLink = this.element.findElements(By.cssSelector("#layer_cart a")).get(0);
		checkoutLink.click();
		return new CheckoutPage(((WrapsDriver)element).getWrappedDriver());
	}
}