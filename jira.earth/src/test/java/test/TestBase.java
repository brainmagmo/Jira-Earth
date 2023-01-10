package test;

import java.io.FileNotFoundException;
import java.time.Duration;

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
	    try {
	        Config config = new Config("options.json");
	        var browserType = config.get("browserType");

	        driverManager = DriverManagerFactory.getManager(browserType);
	        driverManager.createDriver();
	        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        this.pageRepository = new PageRepository(driverManager.getDriver());
	    }
	    catch(FileNotFoundException e) {
	        System.err.println("Configuration file does not exist.");
	        e.printStackTrace();
	    }
	}

	@AfterMethod
	public void cleanup() {
		driverManager.quitDriver();
	}

	protected PageRepository fromPages() {
		return this.pageRepository;
	}
}