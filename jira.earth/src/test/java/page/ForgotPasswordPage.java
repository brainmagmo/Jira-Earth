package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends InvenAutoPage {

    @FindBy(css="#email")
    private WebElement inputElement; 
    
    @FindBy(xpath=".//p[@class='submit']/button[@type='submit']")
    private WebElement retrievePasswordButton;
    
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.route = "index.php?controller=password";
    }
    
    public ForgotPasswordPage fillOutEmailInput(String email) {
        this.inputElement.sendKeys(email);
        return this;
    }
    
    public ForgotPasswordPage clickRetrievePassword() {
        retrievePasswordButton.click();
        return this;
    }
    
    public boolean hasEmailBeenSent() {
        return this.driver.findElements(By.cssSelector("p.alert-success")).size() > 0;
    }

    @Override
    public ForgotPasswordPage navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }
}