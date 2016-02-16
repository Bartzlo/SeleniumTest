package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Белоусов on 11.02.2016.
 */
public class SimplePage {
    private WebDriver driver;
    private String pageAdres = "http://rkc-lesnoy.ru/component/users/?view=login";
    private By loginForm = new By.ByCssSelector("input#username");
    private By passForm = new By.ByCssSelector("input#password");

    public SimplePage(WebDriver driver){
        this.driver = driver;
    }

    public void openHomePage(){
        driver.get(pageAdres);
    }

    public void enterLogin(String login){
        driver.findElement(loginForm).sendKeys(login);
    }

    public void enterPass(String pass){
        driver.findElement(passForm).sendKeys(pass);
    }

}
