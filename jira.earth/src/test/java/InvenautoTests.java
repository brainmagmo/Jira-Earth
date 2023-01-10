import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvenautoTests extends TestBase {

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
    public void fr001B1_canLogin() {
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

	@Test
	public void fr004b2_canViewProductDetails() {
	    var expectedProductName = "Faded Short Sleeves T-shirt";

	    var product1 = fromPages().getProductDetail(1).navigate();

	    var actualProductName =  product1.getTitle();

		Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match");
	}

    @Test
    public void fr007B4_canCheckoutAfterProductinCart() {

    	var homePage = fromPages()
    			.getHomePage()
    			.navigate();

    	homePage.getProductListing()
    			.addToCart();

        var itemsExistInCartOnCheckoutPage = homePage
                .getProductPopUp()
                .clickProceedToCheckout()
    			.areThereProducts();

        Assert.assertTrue(itemsExistInCartOnCheckoutPage, "should be able to checkout");
    }

	@Test 
	public void fr007B1_canAddToCartFromDetailPage() {
		var expectedCartCount = "1";

		var actualCartCount 
		   = fromPages()
		       .getProductDetail(2)
		       .navigate()
		       .addTocart()
		       .getCartCount();

		Assert.assertEquals(actualCartCount, expectedCartCount, "product should be added to cart");
	}
}