package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailPage extends Page{

    @FindBy(how=How.XPATH, using=".//h1[@itemprop='name']")
    private WebElement titleElement;
    
	public ProductDetailPage(WebDriver driver, int productID) {
		super(driver);		
		this.route ="?id_product=" + productID + "&controller=product";		
	}

	public ProductDetailPage addTocart() {
		this.driver.findElement(By.xpath("//SPAN[text()='Add to cart']")).click();		
		return this;
	}

	public String getTitle() {
	    return titleElement.getText();
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