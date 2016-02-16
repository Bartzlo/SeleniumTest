package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage {

    private final WebDriver driver;
    private final String url = "http://rkc-lesnoy.ru/component/users/?view=login";

    @FindBy(css = "input#username")
    private WebElement loginForm;

    @FindBy(css = "input#password")
    private WebElement passForm;

    @FindBy(css = "div.controls button")
    private WebElement submitButton;

    @FindBy(id = "system-message-container")
    private WebElement errorMessage;

    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public boolean validate(){
        return driver.getCurrentUrl().contains(url);
    }

    public LogOutPage login(String login, String password){
        loginForm.sendKeys(login);
        passForm.sendKeys(password);
        submitButton.click();
        return new LogOutPage(driver);
    }

    public boolean chekErrorMessage(){
        return driver.getPageSource().contains("Имя пользователя и пароль не совпадают или у вас еще нет учетной записи на сайте");
    }
}