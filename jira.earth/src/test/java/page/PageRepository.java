package page;

import org.openqa.selenium.WebDriver;

public class PageRepository {

	private WebDriver driver;
	private HomePage homePage;
	private SigninPage signinPage;
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

	public ProductDetailPage getProductDetail() {
		if(this.ProductDetailPage == null)
			this.ProductDetailPage = new ProductDetailPage(this.driver);
		return this.ProductDetailPage;
	}

}
