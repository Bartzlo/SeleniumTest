import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.PricePage;

import java.util.concurrent.TimeUnit;

public class TestClass {

    static WebDriver driver;
    static PricePage pricePage;

    @BeforeClass
    static public void setUpBeforeTest(){
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(1281, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pricePage = new PricePage(driver);
    }

    @After
    public void setUpAfterTest(){
    }

    @AfterClass
    static public void SetUpAfterClass(){
        //driver.quit();
    }

    @Test
    public void tabsAvailability(){
        Assert.assertTrue("Page is don't opened", pricePage.open());

        Assert.assertTrue("First tab is not displayed", pricePage.firstTab.isDisplayed());
        Assert.assertTrue("First tab is not displayed", pricePage.secondTab.isDisplayed());
        Assert.assertTrue("First tab is not displayed", pricePage.thirbTab.isDisplayed());
        Assert.assertTrue("First tab is not displayed", pricePage.fourthTab.isDisplayed());
        Assert.assertTrue("First tab is not displayed", pricePage.fifthTab.isDisplayed());

        Assert.assertTrue("First tab is not active", pricePage.firstTab.activate());
        Assert.assertTrue("First tab is not active", pricePage.secondTab.activate());
        Assert.assertTrue("First tab is not active", pricePage.thirbTab.activate());
        Assert.assertTrue("First tab is not active", pricePage.fourthTab.activate());
        Assert.assertTrue("First tab is not active", pricePage.fifthTab.activate());
    }

    @Ignore
    @Test
    public void firstTab(){

    }
}