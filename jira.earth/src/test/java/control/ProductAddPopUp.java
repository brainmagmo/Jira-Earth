package control;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductAddPopUp extends Control {
	@FindBy(css="#layer_cart a")
	private WebElement checkoutLink;

	public ProductAddPopUp(WebElement element) {
		super(element);
	}
	
	public void clickProceedToCheckout() {
		checkoutLink.click();
	}

}
