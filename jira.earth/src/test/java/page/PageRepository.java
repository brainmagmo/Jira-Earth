package page;

import org.openqa.selenium.WebDriver;

public class PageRepository {

    private WebDriver driver;
    
	public PageRepository(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
	    return new HomePage(this.driver);
	}

	public SigninPage getSigninPage() {
	    return new SigninPage(this.driver);
	}

	public AccountPage getAccountPage() {
	    return new AccountPage(this.driver);
	}

	public ProductDetailPage getProductDetail(int id) {
		return new ProductDetailPage(this.driver, id);
	}

	public CheckoutPage getCheckoutPage() {
	    return new CheckoutPage(this.driver);
	}
}