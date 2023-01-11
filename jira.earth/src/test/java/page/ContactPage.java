package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends InvenAutoPage {

    @FindBy(css="#id_contact")
    private WebElement subjectHeadingSelect;
    
    @FindBy(css="#email")
    private WebElement emailInput;
    
    @FindBy(css="#id_order")
    private WebElement orderReferenceInput;
    
    @FindBy(css="#message")
    private WebElement messageInput;
    
    @FindBy(css="#submitMessage")
    private WebElement sendButton;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.route = "index.php?controller=contact";
    }
    
    public ContactPage fillOutForm(String email, String orderReference, String message) {
        this.subjectHeadingSelect.sendKeys("C");
        this.subjectHeadingSelect.sendKeys(Keys.ENTER);

        this.emailInput.sendKeys(email);
        this.orderReferenceInput.sendKeys(orderReference);
        this.messageInput.sendKeys(message);
        this.sendButton.click();
        
        return this;
     }

    public boolean hasContactBeenSuccessful() {
        return this.driver.findElements(By.cssSelector("p.alert-success")).size() > 0;
    }

    @Override
    public ContactPage navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }
}