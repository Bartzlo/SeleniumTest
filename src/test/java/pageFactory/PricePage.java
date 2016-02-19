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
    public SecondTab secondTab;
    public ThirdTab thirdTab;
    public FourthTab fourthTab;
    public FifthTab fifthTab;
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
    private List<WebElement> firstTabButtons;

    // Second tab
    @FindBy(css = "span.price-resume-access__change-item")
    private WebElement changeRegionLink;

    @FindBy(css = "div.price-resume-access__periods span.bloko-radio__text")
    private List<WebElement> radioButtons;

    @FindBy(css = "div.price-resume-access__periods input[type=radio]")
    private List<WebElement> radioIndicates;

    @FindBy(css = "button[data-qa=cart-resume-access__button-add]")
    private WebElement addToCatrButton;

    //Thirb tab
    @FindBy(css = "div[class*=price-countable-services_4-columns] button[class*=bloko-button]")
    private List<WebElement> thirbTabButtons;

    @FindBy(css = "div[class*=price-countable-services_4-columns] input[class*=bloko-input]")
    private List<WebElement> thirbTabInputs;

    //Fourth tab
    @FindBy(css = "div[class*=price-countable-services_3-columns] button[class*=bloko-button]")
    private List<WebElement> fourthTabButtons;

    @FindBy(css = "div[class*=price-countable-services_3-columns] input[class*=bloko-input]")
    private List<WebElement> fourthTabInputs;

    //Fifth tab
    @FindBy(css = "div[class*=price-countable-services_2-columns] button[class*=bloko-button]")
    private List<WebElement> fifthTabButtons;

    @FindBy(css = "div[class*=price-countable-services_2-columns] input[class*=bloko-input]")
    private List<WebElement> fifthTabInputs;

    @FindBy(css = "div[class*=price-additional-subfilter] span")
    private List<WebElement> subTabs;

    @FindBy(css = "div[class*=price-additional-subfilter] span[class*=m-switchrow__switch_selected]")
    private WebElement activeSubTab;

    // Price cart
    @FindBy(css = "div.HH-PriceCart")
    private WebElement cartItems;

    @FindBy(css = "div.HH-PriceCart span.price-cart__item-remove")
    private WebElement itemRemover;

    @FindBy(css = "div.HH-PriceCart span.price-cart__button")
    WebElement buyButton;


    public PricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get(url);
        firstTab = new FirstTab(tabs.get(0));
        secondTab = new SecondTab(tabs.get(1));
        thirdTab = new ThirdTab(tabs.get(2));
        fourthTab = new FourthTab(tabs.get(3));
        fifthTab = new FifthTab(tabs.get(4));
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
            return firstTabButtons;
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

    public class ThirdTab{
        WebElement tab;

        public ThirdTab(WebElement tab){
            this.tab = tab;
        }

        public WebElement getTitleTab() {
            return tab;
        }

        public boolean isActivated() {
            return tab.equals(activeTab);
        }

        public List<WebElement> getInputs(){
            return thirbTabInputs;
        }

        public List<WebElement> getButtons(){
            return thirbTabButtons;
        }
    }

    public class FourthTab{
        WebElement tab;

        public FourthTab(WebElement tab){
            this.tab = tab;
        }

        public WebElement getTitleTab() {
            return tab;
        }

        public boolean isActivated() {
            return tab.equals(activeTab);
        }

        public List<WebElement> getButtons(){
            return fourthTabButtons;
        }

        public List<WebElement> getInputs(){
            return fourthTabInputs;
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

    public class FifthTab{
        WebElement tab;

        public FifthTab(WebElement tab){
            this.tab = tab;
        }

        public WebElement getTitleTab() {
            return tab;
        }

        public boolean isActivated() {
            return tab.equals(activeTab);
        }

        public List<WebElement> getButtons(){
            return fifthTabButtons;
        }

        public List<WebElement> getInputs(){
            return fifthTabInputs;
        }

        public List<WebElement> getSubTabs(){
            return subTabs;
        }

        public boolean checkSubTabForAvtive(WebElement n){
            return n.equals(activeSubTab);
        }
    }

}