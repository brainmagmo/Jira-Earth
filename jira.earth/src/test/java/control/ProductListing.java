package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListing extends Control {

    public ProductListing(WebElement element) {
        super(element);
    }

    public ProductAddPopUp addToCart() {
    	WebElement addToCartButton = this.element.findElements(By.xpath("//span[text()='Add to cart']")).get(0);
    	addToCartButton.click();
    	//problem is we're searching the element instead of the page need to cast element to driver
    	WebElement popUp = this.element.findElement(By.id("layer_cart"));
        return new ProductAddPopUp(popUp); 
    }
}