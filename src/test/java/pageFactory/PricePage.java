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

    public FirstTab firstTab = new FirstTab();
    public SecondTab secondTab = new SecondTab();
    public ThirbTab thirbTab = new ThirbTab();
    public FourthTab fourthTab = new FourthTab();
    public FifthTab fifthTab = new FifthTab();

    // general elements
    @FindBy(className = "flat-tabs__switcher")
    private List<WebElement> tabs;

    // First tab elements
    @FindBy(css = "button.bloko-button_small")
    private WebElement button;

    /*FindBy(xpath = "//a[contains(@data-qa, 'cart__tab_publications')]")
    private WebElement secondTab;*/

    public PricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean open() {
        driver.get(url);
        return driver.getCurrentUrl().contains(urlChesk);
    }

    public class FirstTab {
        public boolean activate() {
            tabs.get(0).click();
            return tabs.get(0).getAttribute("class").contains("flat-tabs__switcher_active");
        }
        public boolean isDisplayed() {
            return tabs.get(0).isDisplayed();
        }
    }

    public class SecondTab {
        public boolean activate() {
            tabs.get(1).click();
            return tabs.get(1).getAttribute("class").contains("flat-tabs__switcher_active");
        }
        public boolean isDisplayed() {
            return tabs.get(1).isDisplayed();
        }
    }

    public class ThirbTab {
        public boolean activate() {
            tabs.get(2).click();
            return tabs.get(2).getAttribute("class").contains("flat-tabs__switcher_active");
        }
        public boolean isDisplayed() {
            return tabs.get(2).isDisplayed();
        }
    }

    public class FourthTab {
        public boolean activate() {
            tabs.get(3).click();
            return tabs.get(3).getAttribute("class").contains("flat-tabs__switcher_active");
        }
        public boolean isDisplayed() {
            return tabs.get(3).isDisplayed();
        }
    }

    public class FifthTab {
        public boolean activate() {
            tabs.get(4).click();
            return tabs.get(4).getAttribute("class").contains("flat-tabs__switcher_active");
        }
        public boolean isDisplayed() {
            return tabs.get(4).isDisplayed();
        }
    }

}