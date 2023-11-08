package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageEbayHome extends PageBase{

    Actions actions = null;

    @FindBy(xpath = "//a[@id='gh-as-a']")
    public WebElement buttonAdvanced;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a")
    public WebElement iconShoppingCart;

    @FindBy(xpath = "//h3[text()=' Tools & apps']")
    public WebElement footerLabelToolsAndApps;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement footerButtonDevelopers;

    @FindBy(xpath = "//li/a[text()='Sports']")
    public WebElement topNavigationSportsItem;

    @FindBy(xpath = "//a[text()='Cycling']")
    public WebElement topNavigationSportsItemCycling;

    @FindBy(xpath = "//td[@class='gf-legal']")
    public WebElement bottomLine;

    public PageEbayHome(WebDriver driver) {
        super(driver);
    }

    public PageAdvanceSearch clickAdvancedSearchButton(){
        buttonAdvanced.click();

        return PageFactory.initElements(driver, PageAdvanceSearch.class);
    }


}

