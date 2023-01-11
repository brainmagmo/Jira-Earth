package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import control.ProductAddPopUp;
import control.ProductListing;

public class HomePage extends InvenAutoPage {

    @FindBy(how=How.CSS, using=".product-container")
    private WebElement productListing; 

    @FindBy(css=".layer_cart_cart a")
	private WebElement checkoutLink;

    @FindBy(css="#contact-link a")
    private WebElement contactUsButton;

	public HomePage(WebDriver driver) {
		super(driver);
		this.route = "index.php";
	}

	public ProductListing getProductListing() {
	    return new ProductListing(this.productListing);
	}

	public CheckoutPage clickProceedToCheckout() {
	    checkoutLink.click();
	    return new CheckoutPage(this.driver);
	}

	public ProductAddPopUp  getProductPopUp() {
		WebElement popUp = this.driver.findElement(By.id("layer_cart"));
		return new ProductAddPopUp(popUp); 
	}
	
    public HomePage navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }

    public ContactPage clickContactUsButton() {
        this.contactUsButton.click();
        return new ContactPage(this.driver);
    }
}