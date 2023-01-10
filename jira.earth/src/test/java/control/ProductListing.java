package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductListing extends Control {

    public ProductListing(WebElement element) {
        super(element);
    }

    public void addToCart() {
    	WebElement addToCartButton = this.element.findElement(By.xpath("//span[text()='Add to cart']"));
    	addToCartButton.click();
    }
}