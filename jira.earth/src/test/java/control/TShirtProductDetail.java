package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TShirtProductDetail extends Control {

	WebDriver driver;

	public TShirtProductDetail(WebElement element, WebDriver driver) {
		super(element);
		this.driver = driver;
	}

	public String getResult() {

		var result = this.driver.findElement(By.xpath("//h1[contains(text(), 'Faded Short Sleeves T-shirt')]"))
				.getText();
		return result;
	}

	public String getPrice() {
		var result = this.driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
		return result;
	}

	public String getCondition() {
		var result = this.driver.findElement(By.xpath(("//p[@id='product_condition']/span[@class='editable']")))
				.getText();
		return result;
	}
}