package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvenAutoTests extends TestBase {

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

    	Assert.assertEquals(actualUser, expectedUser, "User not signed in");
    }

	@Test
	public void fr004B2_canViewProductDetails() {
	    var expectedProductName = "Faded Short Sleeves T-shirt";
	    var expectedCondition = "New product";
	    var expectedDescription = "Faded short sleeves t-shirt with high neckline. Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!";
	    var expectedPrice = "$16.51";

	    var product1 = fromPages().getProductDetail(1).navigate();

	    var actualProductName =  product1.getTitle();
	    var actualCondition = product1.getCondition();
	    var actualDescription = product1.getDescription();
	    var actualPrice = product1.getPrice();

		Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match");
		Assert.assertEquals(actualCondition, expectedCondition, "Condition does not match");
		Assert.assertEquals(actualDescription, expectedDescription, "Description does not match");
		Assert.assertEquals(actualPrice, expectedPrice, "Price does not match");
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
		       .addToCart()
		       .getCartCount();

		Assert.assertEquals(actualCartCount, expectedCartCount, "product should be added to cart");
	}
	
	@Test
	public void fr001B2_canResetPassword() {
	    var emailSuccessful
	        = fromPages()
	            .getSigninPage()
	            .navigate()
	            .clickForgotPassword()
	            .fillOutEmailInput("email@email.com")
	            .clickRetrievePassword()
	            .hasEmailBeenSent();
	    
	    Assert.assertTrue(emailSuccessful, "email should have been sent");
	}
	
	@Test
	public void fr13B1_canContactSupport() {
	    var email = "email@email.com";
	    var orderReference = "1212";
	    var message = "Please cancel this order.";

	    var contactSuccess
	        = fromPages()
	            .getHomePage()
	            .navigate()
	            .clickContactUsButton()
	            .fillOutForm(email, orderReference, message)
	            .hasContactBeenSuccessful();

	    Assert.assertTrue(contactSuccess, "contact success expected");
	}
}