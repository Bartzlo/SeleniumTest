import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        assertTrue("Second tab is not displayed", pricePage.secondTab.getTitleTab().isDisplayed());

        pricePage.firstTab.getTitleTab().click();
        assertTrue("First tab is not active", pricePage.firstTab.isActivated());

        pricePage.secondTab.getTitleTab().click();
        assertTrue("Second tab is not active", pricePage.secondTab.isActivated());
    }

    @Test
    public void buyButton(){
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.firstTab.getTitleTab().click();
        List<WebElement> buttons = pricePage.firstTab.getButtons();

        assertTrue("Buttons is not displayed", buttons.get(0).isDisplayed());
        buttons.get(0).click();
        assertTrue("Item is not submit", pricePage.priceCart.getCartItem().getText().contains("Вакансия Стандарт+"));

        assertTrue("Buy button is not displayed", pricePage.priceCart.getBuyButton().isDisplayed());
        pricePage.priceCart.getBuyButton().click();
        assertTrue("It is not authorization page", driver.getCurrentUrl().contains("hh.ru/auth/employer"));
    }

    @Test
    public void firstTabAndCartItemRemove(){
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.firstTab.getTitleTab().click();
        assertTrue("First tab is not active", pricePage.firstTab.isActivated());
        List<WebElement> buttons = pricePage.firstTab.getButtons();

        assertTrue("Button 1 is not displayed", buttons.get(0).isDisplayed());
        buttons.get(0).click();
        assertTrue("Item 1 is not submit", pricePage.priceCart.getCartItem().getText().contains("Вакансия Стандарт+"));
        assertTrue("Button 1 is not disabled", Boolean.parseBoolean(buttons.get(0).getAttribute("disabled")));

        assertTrue("Button 2 is not displayed", buttons.get(1).isDisplayed());
        buttons.get(1).click();
        assertTrue("Item 2 is not submit", pricePage.priceCart.getCartItem().getText().contains("Неделя доступа к базе резюме"));
        assertTrue("Button 2 is not disabled", Boolean.parseBoolean(buttons.get(1).getAttribute("disabled")));

        pricePage.priceCart.getItemRemover().click();
        pricePage.priceCart.getItemRemover().click();
        assertFalse("Item is not removed", pricePage.priceCart.getCartItem().getText().contains("Вакансия Стандарт+"));
        assertFalse("Item is not removed", pricePage.priceCart.getCartItem().getText().contains("Неделя доступа к базе резюме"));
    }

    @Test
    public void secondTab(){
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.secondTab.getTitleTab().click();
        assertTrue("Second tab is not active", pricePage.secondTab.isActivated());

        assertTrue("Change region link is not displayed", pricePage.secondTab.getChangeRegionLink().isDisplayed());
        assertTrue("Radio button 1 is not displayed", pricePage.secondTab.getRadios().get(0).isDisplayed());
        assertTrue("Radio button 2 is not displayed", pricePage.secondTab.getRadios().get(1).isDisplayed());
        assertTrue("Radio button 3 is not displayed", pricePage.secondTab.getRadios().get(2).isDisplayed());
        assertTrue("Radio button 4 is not displayed", pricePage.secondTab.getRadios().get(3).isDisplayed());
        assertTrue("Radio button 5 is not displayed", pricePage.secondTab.getRadios().get(4).isDisplayed());
        assertTrue("Add to cart button i not displayed", pricePage.secondTab.getAddToCatrButton().isDisplayed());

        pricePage.secondTab.getRadios().get(0).click();
        assertTrue("Radio button 1 is not activated", pricePage.secondTab.getRadioIndicates().get(0).isSelected());
        assertFalse("Radio button 1 is activated", pricePage.secondTab.getRadioIndicates().get(1).isSelected());

        pricePage.secondTab.getAddToCatrButton().click();
        assertTrue("Item is not submit", pricePage.priceCart.getItemRemover().isDisplayed());
    }

    @Test
    public void thirdTab() {
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.thirdTab.getTitleTab().click();
        assertTrue("Second tab is not active", pricePage.thirdTab.isActivated());

        pricePage.thirdTab.getButtons().get(0).click();
        pricePage.thirdTab.getButtons().get(1).click();
        pricePage.thirdTab.getButtons().get(2).click();
        pricePage.thirdTab.getInputs().get(3).click();
        pricePage.thirdTab.getInputs().get(3).sendKeys(Keys.ENTER);

        assertTrue("Item 1 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  вакансия Стандарт"));
        assertTrue("Item 2 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  вакансия Стандарт плюс"));
        assertTrue("Item 3 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  вакансия Премиум"));
        assertTrue("Item 4 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  анонимная вакансия"));

        pricePage.thirdTab.getInputs().get(3).clear();
        pricePage.thirdTab.getInputs().get(3).sendKeys("2");
        pricePage.thirdTab.getInputs().get(3).sendKeys(Keys.ENTER);
        assertTrue("Item 4 is not refresh with enter ", pricePage.priceCart.getCartItem().getText().contains("2  анонимных вакансии"));

        pricePage.thirdTab.getInputs().get(3).clear();
        pricePage.thirdTab.getInputs().get(3).sendKeys("3");
        pricePage.thirdTab.getButtons().get(3).click();
        assertTrue("Item 4 is not refresh with button ", pricePage.priceCart.getCartItem().getText().contains("3  анонимных вакансии"));
    }

    @Test
    public void fourthTab() {
        pricePage = new PricePage(driver);
        assertTrue("Page is not open", pricePage.validation());

        pricePage.fourthTab.getTitleTab().click();
        assertTrue("Second tab is not active", pricePage.fourthTab.isActivated());

        pricePage.fourthTab.getButtons().get(0).click();
        pricePage.fourthTab.getButtons().get(1).click();
        pricePage.fourthTab.getInputs().get(2).click();
        pricePage.fourthTab.getInputs().get(2).sendKeys(Keys.ENTER);

        assertTrue("Item 1 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  динамический тест числовых способностей"));
        assertTrue("Item 2 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  динамический тест вербальных способностей"));
        assertTrue("Item 3 is not submit", pricePage.priceCart.getCartItem().getText().contains("1  опросник выявления универсальных компетенций"));

        pricePage.fourthTab.getInputs().get(2).clear();
        pricePage.fourthTab.getInputs().get(2).sendKeys("2");
        pricePage.fourthTab.getInputs().get(2).sendKeys(Keys.ENTER);
        assertTrue("Item 4 is not refresh with enter ", pricePage.priceCart.getCartItem().getText().contains("2  опросника выявления универсальных компетенций"));

        pricePage.fourthTab.getInputs().get(2).clear();
        pricePage.fourthTab.getInputs().get(2).sendKeys("3");
        pricePage.fourthTab.getButtons().get(2).click();
        assertTrue("Item 4 is not refresh with button ", pricePage.priceCart.getCartItem().getText().contains("3  опросника выявления универсальных компетенций"));
    }
}
