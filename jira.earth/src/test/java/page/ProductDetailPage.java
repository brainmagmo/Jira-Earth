package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends Page{
	
	private int productID = 2;
	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);		
		this.route ="?id_product="+productID+"&controller=product";		
	}
	
	public ProductDetailPage(WebDriver driver, int productID) {
		super(driver);		
		this.route ="?id_product="+productID+"&controller=product";		
	}
	
	public ProductDetailPage addTocart() {
		this.driver.findElement(By.xpath("//SPAN[text()='Add to cart']")).click();		
		return this;
	}

	
	public String isInCart() {
		String s = this.driver.findElement(By.xpath("//*[contains(@class,'ajax_cart_quantity')][contains(@style, 'display: inline')]")).getText();
		return s;
	}

	@Override
	public ProductDetailPage navigate() {
		this.driver.navigate().to(getURL());
		return this;
	}
	
}

	


