package pageFactory;

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

    // Price cart
    @FindBy(css = "div.HH-PriceCart")
    WebElement cartItems;

    @FindBy(css = "div.HH-PriceCart span.price-cart__item-remove")
    WebElement itemRemover;


    public PricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get(url);
        firstTab = new FirstTab(tabs.get(0));
        priceCart = new PriceCart();
    }

    public boolean validation() {
        return driver.getCurrentUrl().contains(urlChesk);
    }

    public class FirstTab {
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

    public class PriceCart {

        public WebElement getCartItem(){
            return cartItems;
        }

        public WebElement getItemRemover(){
            return itemRemover;
        }
    }

}