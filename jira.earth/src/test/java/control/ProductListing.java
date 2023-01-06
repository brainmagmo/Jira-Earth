package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductListing extends Control {

    public ProductListing(WebElement element) {
        super(element);
    }

    public ProductAddPopUp addToCart() {
        String xpath = "./span[text()='Add to Cart']/../..";
        WebElement addToCartButton = this.element.findElement(By.xpath(xpath));
        addToCartButton.click();
        
        WebElement popUp = this.element.findElement(By.id("layer_cart"));
        return new ProductAddPopUp(popUp); 
    }
}