package page;

import org.openqa.selenium.WebDriver;

public class PageRepository {

	private WebDriver driver;
	private HomePage homePage;
	private SigninPage signinPage;

	private AccountPage accountPage;

	private ProductDetailPage ProductDetailPage;

	public PageRepository(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		if(this.homePage == null)
			this.homePage = new HomePage(this.driver);
		return this.homePage;
	}

	public SigninPage getSigninPage() {
		if(this.signinPage == null)
			this.signinPage = new SigninPage(this.driver);
		return this.signinPage;
	}


	public AccountPage getAccountPage() {
		if(this.accountPage == null)
			this.accountPage = new AccountPage(this.driver);
		return this.accountPage;
}
	public ProductDetailPage getProductDetail() {
		if(this.ProductDetailPage == null)
			this.ProductDetailPage = new ProductDetailPage(this.driver);
		return this.ProductDetailPage;

	}

	public CheckoutPage getCheckoutPage() {
	    return new CheckoutPage(this.driver);
	}
}