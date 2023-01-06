package control;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListing extends Control {
	@FindBy(xpath="./span[text()='Add to Cart']/../..")
	private WebElement addToCartButton;
	@FindBy(id="layer_cart")
	private WebElement popUp;

    public ProductListing(WebElement element) {
        super(element);
    }

    public ProductAddPopUp addToCart() {

        return new ProductAddPopUp(popUp); 
    }
}