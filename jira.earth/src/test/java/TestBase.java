
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.DriverManager;
import driver.DriverManagerFactory;
import page.PageRepository;

public abstract class TestBase {

	private PageRepository pageRepository;
	protected DriverManager driverManager;
	
	@BeforeMethod
	public void setup() {
		var browserType = "chrome";
		driverManager = DriverManagerFactory.getManager(browserType);
		driverManager.createDriver();
		driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.pageRepository = new PageRepository(driverManager.getDriver());
	}

	@AfterMethod
	public void cleanup() {
		driverManager.quitDriver();
	}

	protected PageRepository fromPages() {
		return this.pageRepository;
	}
}