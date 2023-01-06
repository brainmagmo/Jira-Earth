package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class ProductListing extends Control {

    public ProductListing(WebElement element) {
        super(element);
    }

    public void addToCart() {
    	WebElement addToCartButton = this.element.findElements(By.xpath("//span[text()='Add to cart']")).get(0);
    	addToCartButton.click();
    }
}