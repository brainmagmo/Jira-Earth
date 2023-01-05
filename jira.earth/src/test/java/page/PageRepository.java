package page;

import org.openqa.selenium.WebDriver;

public class PageRepository {

	private WebDriver driver;
	private HomePage homePage;

	public PageRepository(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		if(this.homePage == null)
			this.homePage = new HomePage(this.driver);
		return this.homePage;
	}

}
