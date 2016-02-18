import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.PricePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestClass {

    private static WebDriver driver;
    private PricePage pricePage;

    @BeforeClass
    static public void setUpBeforeTest(){
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(1281, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());
        assertTrue("First tab is not displayed", pricePage.firstTab.getTitleTab().isDisplayed());
        pricePage.firstTab.getTitleTab().click();
        assertTrue("First tab is not active", pricePage.firstTab.isActivated());
    }

    @Test
    public void firstTabAndCartItemRemove(){
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.firstTab.getTitleTab().click();
        List<WebElement> buttons = pricePage.firstTab.getButtons();

        assertTrue("Buttons is not displayed", buttons.get(0).isDisplayed());
        buttons.get(0).click();
        assertTrue("Click don't give result", pricePage.priceCart.getCartItem().getText().contains("Вакансия Стандарт+"));
        assertTrue("Button is not disabled1", Boolean.parseBoolean(buttons.get(0).getAttribute("disabled")));

        assertTrue("Buttons is not displayed", buttons.get(1).isDisplayed());
        buttons.get(1).click();
        assertTrue("Click don't give result", pricePage.priceCart.getCartItem().getText().contains("Неделя доступа к базе резюме"));
        assertTrue("Button is not disabled1", Boolean.parseBoolean(buttons.get(1).getAttribute("disabled")));

        pricePage.priceCart.getItemRemover().click();
        pricePage.priceCart.getItemRemover().click();
        assertFalse("Item is not removed", pricePage.priceCart.getCartItem().getText().contains("Вакансия Стандарт+"));
        assertFalse("Item is not removed", pricePage.priceCart.getCartItem().getText().contains("Неделя доступа к базе резюме"));
    }
}
