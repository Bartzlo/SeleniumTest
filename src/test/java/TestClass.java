import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.LogInPage;
import pageFactory.LogOutPage;

import java.util.concurrent.TimeUnit;

public class TestClass {

    static WebDriver driver;
    static LogInPage logInPage;
    static LogOutPage logOutPage;

    @Before
    public void setUpBeforeTest(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void setUpAfterTest(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertTrue("Открыта не та страцица", logInPage.validate());
        logOutPage = logInPage.login("Username", "userpassword");
        Assert.assertTrue("Открыта не та страцица", logOutPage.validate());
        logOutPage.clickExit();
    }

    @Test
    public void incorrectPass(){
        logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertTrue("Открыта не та страцица", logInPage.validate());
        logInPage.login("Username", "userpassword");
        Assert.assertTrue("Сообщение об ошибке не найдено", logInPage.chekErrorMessage());

    }
}