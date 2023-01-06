import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

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

		var selectedURL = fromPages()
				.getHomePage()
				.navigate()
				.getURL();

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
    	
    	var signinPage = (SigninPage)fromPages()
    			.getSigninPage()
    			.navigate();
    	var actualUser = signinPage
    			.signIn(sampleEmail, samplePassword)
    			.getUserName();
    	Assert.assertEquals(expectedUser, actualUser, "Correct user signed in");
    	
    }

    @Test
    public void canCheckoutAfterProductinCart() {
    	var homePage = (HomePage)fromPages()
    			.getHomePage()
    			.navigate();

    	homePage
    	   .getProductListing()
    	   .addToCart();
    	
    	var checkoutPage = 
    	    homePage
    	        .clickProceedToCheckout();

        var itemsExistInCartOnCheckoutPage = checkoutPage.areThereProducts();
    	
        Assert.assertTrue(itemsExistInCartOnCheckoutPage, "should be able to checkout");
    }
}