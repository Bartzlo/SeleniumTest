package pageFactory;

import org.apache.xalan.lib.sql.ConnectionPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class PricePage {
    private final WebDriver driver;
    private final String url = "http://hh.ru/price";
    private final String urlChesk = "hh.ru/price";

    public FirstTab firstTab;
    public SecondTab secondTab;
    public PriceCart priceCart;

    // general elements
    @FindBy(className = "flat-tabs__switcher")
    private List<WebElement> tabs;

    @FindBy(className = "flat-tabs__switcher_active")
    private WebElement activeTab;

    // First tab elements
    @FindBy(css = "button.bloko-button_small")
    private WebElement button;

    @FindBy(css = "div.g-expandable button")
    private List<WebElement> buttons;

    // Second tab
    @FindBy(css = "span.price-resume-access__change-item")
    WebElement changeRegionLink;

    @FindBy(css = "div.price-resume-access__periods span.bloko-radio__text")
    List<WebElement> radioButtons;

    @FindBy(css = "div.price-resume-access__periods input[type=radio]")
    List<WebElement> radioIndicates;

    @FindBy(css = "button[data-qa=cart-resume-access__button-add]")
    WebElement addToCatrButton;

    // Price cart
    @FindBy(css = "div.HH-PriceCart")
    WebElement cartItems;

    @FindBy(css = "div.HH-PriceCart span.price-cart__item-remove")
    WebElement itemRemover;

    @FindBy(css = "div.HH-PriceCart span.price-cart__button")
    WebElement buyButton;


    public PricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get(url);
        firstTab = new FirstTab(tabs.get(0));
        secondTab = new SecondTab(tabs.get(1));
        priceCart = new PriceCart();
    }

    public boolean validation() {
        return driver.getCurrentUrl().contains(urlChesk);
    }

    public class FirstTab{
        WebElement tab;

        public FirstTab(WebElement tab){
            this.tab = tab;
        }

        public WebElement getTitleTab() {
            return tab;
        }

        public boolean isActivated() {
            return tab.equals(activeTab);
        }

        public List<WebElement> getButtons() {
            return buttons;
        }
    }

    public class SecondTab{
        WebElement tab;

        public SecondTab(WebElement tab){
            this.tab = tab;
        }

        public WebElement getTitleTab() {
            return tab;
        }

        public WebElement getChangeRegionLink() {
            return changeRegionLink;
        }

        public List<WebElement> getRadios() {
            return radioButtons;
        }

        public WebElement getAddToCatrButton() {
            return addToCatrButton;
        }

        public boolean isActivated() {
            return tab.equals(activeTab);
        }

        public List<WebElement> getRadioIndicates() {
            return radioIndicates;
        }
    }

    public class PriceCart {

        public WebElement getCartItem(){
            return cartItems;
        }

        public WebElement getItemRemover(){
            return itemRemover;
        }

        public WebElement getBuyButton() {
            return buyButton;
        }
    }

}