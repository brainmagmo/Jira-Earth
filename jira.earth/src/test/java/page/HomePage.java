package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import control.ProductListing;

public class HomePage extends Page {

    @FindBy(how=How.CSS, using=".product-container")
    private WebElement productListing; 

	public HomePage(WebDriver driver) {
		super(driver);
		this.route = "index.php";
	}

	public ProductListing getProductListing() {
	    return new ProductListing(this.productListing);
	}
}