import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page.ProductDetailPage;

public class AddProductFromDetailPage extends TestBase {
	
	@Test
    public void canOpenProductDetailPage() {
    	var expctedURL = "https://invenauto.tech/index.php?id_product=2&controller=product";

		var selectedURL = fromPages()
				.getProductDetail()
				.getURL();

		assertEquals(selectedURL, expctedURL, "The Home Page should be loaded.");
    }
	@Test 
	public void canAddToCartFromDetailPage() {
		var expected = "Product successfully added to your shopping cart";
		
		var actual = fromPages()
					.getProductDetail()
					.navigate()
					.addTocart()
					.isInCart();

	}
}
