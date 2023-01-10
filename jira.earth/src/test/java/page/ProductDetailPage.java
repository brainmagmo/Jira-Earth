package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailPage extends InvenAutoPage {

    @FindBy(how=How.XPATH, using=".//h1[@itemprop='name']")
    private WebElement titleElement;

    @FindBy(how=How.CSS, using="p#product_condition span")
    private WebElement conditionElement;

    @FindBy(how=How.CSS, using="div#short_description_content p")
    private WebElement descriptionElement;

    @FindBy(how=How.CSS, using="span#our_price_display")
    private WebElement priceElement;

	public ProductDetailPage(WebDriver driver, int productID) {
		super(driver);		
		this.route ="?id_product=" + productID + "&controller=product";		
	}

	public ProductDetailPage addToCart() {
		this.driver.findElement(By.xpath("//span[text()='Add to cart']")).click();		
		return this;
	}

	public String getTitle() {
	    return titleElement.getText();
	}

	public String getCondition() {
	    return conditionElement.getText();
	}

	public String getDescription() {
	    return descriptionElement.getText();
	}

	public String getPrice() {
	    return priceElement.getText();
	}

	public String getCartCount() {
	    String xpath = "//*[contains(@class,'ajax_cart_quantity')][contains(@style, 'display: inline')]";
		return this.driver.findElement(By.xpath(xpath)).getText();
	}

	@Override
	public ProductDetailPage navigate() {
		this.driver.navigate().to(getURL());
		return this;
	}
}