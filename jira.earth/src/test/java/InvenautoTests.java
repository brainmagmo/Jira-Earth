import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

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

//    @Test
//    public void canCheckoutAfterProductinCart() {
//        fromPages()
//          .getHomePage()
//          .navigate()
//    }
}
