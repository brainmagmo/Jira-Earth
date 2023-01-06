import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.ChromeDriverManager;

public class InvenautoTests extends TestBase {

	@Test
	public void canTest() {
		return;
	}

	@Test
	public void canOpenIndex() {
		var expctedURL = "https://invenauto.tech/index.php";

		var selectedURL = fromPages().getHomePage().navigate().getURL();

		assertEquals(selectedURL, expctedURL, "The Home Page should be loaded.");
	}

	@Test
	public void canOpenSignInPage() {
		var expctedURL = "https://invenauto.tech/index.php?controller=authentication&back=my-account";

		var selectedURL = fromPages().getSigninPage().navigate().getURL();

		assertEquals(selectedURL, expctedURL, "The Home Page should be loaded.");
	}

	@Test
	public void canSignIn() {
		var sampleEmail = "uwomxdikikacberjff@tmmwj.net";
		var samplePassword = "frank";
		var expectedUser = "Frank franklin";

		var actualUser = fromPages().getSigninPage().signIn(sampleEmail, samplePassword).getUserName();
		Assert.assertEquals(expectedUser, actualUser, "Correct user signed in");

	}

//    @Test
//    public void canCheckoutAfterProductinCart() {
//        fromPages()
//          .getHomePage()
//          .navigate()
//    }
	@Test
	public void ViewProductDetailsForFurtherInformation() {

		WebDriver driver = new ChromeDriver();
		var URL = "https://invenauto.tech/index.php";

		driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.linkText("Women")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeves T-shirt')]")).click();

		var result = driver.findElement(By.xpath("//h1[contains(text(), 'Faded Short Sleeves T-shirt')]")).getText();
		var expectedResult = "Faded Short Sleeves T-shirt";

		Assert.assertEquals(result, expectedResult, "The Webpage title does not match");

	}
	
	@Test
	public void ViewProductDetailsForFurtherInformationNegative() {
		
		WebDriver driver = new ChromeDriver();
		var URL = "https://invenauto.tech/index.php";

		driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.linkText("Women")).click();
		
	}
}
