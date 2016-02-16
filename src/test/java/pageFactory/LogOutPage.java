package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    private final WebDriver driver;
    private final String url = "http://rkc-lesnoy.ru/change-password/profile";

    @FindBy(className = "item-133")
    WebElement exitLink;

    @FindBy(css = "div.controls button")
    WebElement exitButton;

    public LogOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public boolean validate(){
        return driver.getCurrentUrl().contains(url);
    }

    public LogInPage clickExit(){
        exitLink.click();
        exitButton.click();
        return new LogInPage(driver);
    }
}
