package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends Page{

	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
		this.route ="?id_product=2&controller=product";
		
	}

	public void addTocart() {
		this.driver.navigate().to("https://invenauto.tech/index.php?id_product=2&controller=product");
		this.driver.findElement(By.xpath("//SPAN[text()='Add to cart']")).click();
		
	}

	
	public String isInCart() {
		// TODO Auto-generated method stub
		this.driver.navigate().to("https://invenauto.tech/index.php?id_product=2&controller=product");
		this.driver.findElement(By.xpath("//SPAN[text()='Add to cart']")).click();
		
		String s = this.driver.findElement(By.xpath(" //*[text()= 'Product successfully added to your shopping cart '")).getText();
		
		

		return s;
	}

	
}

	


