import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;

import driver.ChromeDriverManager;

import page.HomePage;
import page.SigninPage;

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

		var selectedURL = fromPages()
				.getSigninPage()
				.navigate()
				.getURL();

		assertEquals(selectedURL, expctedURL, "The Home Page should be loaded.");    	
    }
    

      @Test
    public void canSignIn() {
    	var sampleEmail = "uwomxdikikacberjff@tmmwj.net";
    	var samplePassword = "frank";
    	var expectedUser = "Frank franklin";
    	
    	var actualUser = fromPages()
    			.getSigninPage()
    			.navigate()
    			.signIn(sampleEmail, samplePassword)
    			.getUserName();
    	Assert.assertEquals(expectedUser, actualUser, "Correct user signed in");
    	
    }

  //driver shouldn't be in this page...
	@Test
	public void ViewProductDetailsForFurtherInformation() {

		WebDriver driver = new ChromeDriver();
		var URL = "https://invenauto.tech/index.php";

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
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
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Women")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeves T-shirt')]"));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeves T-shirt')]")));
		action.click().build();
		
	}

    


    @Test
    public void canCheckoutAfterProductinCart() {

    	var homePage = fromPages()

    			.getHomePage()
    			.navigate();



    	homePage.getProductListing()
    			.addToCart();
        var itemsExistInCartOnCheckoutPage = homePage
        		.getproductPopUp()
    			.clickProceedToCheckout()
    			.areThereProducts();

    	
        Assert.assertTrue(itemsExistInCartOnCheckoutPage, "should be able to checkout");
    }

}



