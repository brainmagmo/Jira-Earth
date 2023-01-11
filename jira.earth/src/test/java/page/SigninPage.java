package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends InvenAutoPage {

	@FindBy(css="input#email")
	private WebElement emailInput;

	@FindBy(css="input#passwd")
	private WebElement passwordInput;

	@FindBy(css="button#SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(css="p.lost_password a")
	private WebElement forgotPasswordLink;

	public SigninPage(WebDriver driver) {
		super(driver);
		this.route = "index.php?controller=authentication&back=my-account";
	}

	public AccountPage signIn(String username, String password) {
		emailInput.sendKeys(username);
		passwordInput.sendKeys(password);
		signInButton.click();
		return new AccountPage(this.driver);
	}

	public ForgotPasswordPage clickForgotPassword() {
	    this.forgotPasswordLink.click();
	    return new ForgotPasswordPage(this.driver);
	}

    public SigninPage navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }
}