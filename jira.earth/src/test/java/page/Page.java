package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected String index;
    protected String route;
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.index="https://invenauto.tech/";
        PageFactory.initElements(this.driver, this);
    }

    public String getIndex() {
        return this.index;
    }
    
    public String getRoute() {
        return this.route;
    }

    public String getURL() {
        return index + route;
    }

    abstract Page navigate();
}