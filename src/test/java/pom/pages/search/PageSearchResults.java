package pom.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.pages.PageBase;
import pom.pages.shoppingCart.PageShoppingCart;

public class PageSearchResults extends PageBase {

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[@class='s-item s-item__pl-on-bottom'][1]//div[@class='s-item__image-section']")
    public WebElement firstElementSearchResults;

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']")
    public WebElement labelSearchResults;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a")
    public WebElement iconShoppingCart;

    @FindBy(xpath = "//h3[text()='Brand']")
    public WebElement labelBrand;

    @FindBy(xpath = "//span[text()='LG']")
    public WebElement checkBoxBrandLG;

    @FindBy(xpath = "//span[text()='Samsung']")
    public WebElement checkBoxBrandSamsung;

    @FindBy(xpath = "//h3[text()='Display Technology']")
    public WebElement labelDisplayTechnology;

    @FindBy(xpath = "//span[text()='Plasma']")
    public WebElement checkBoxDisplayTechnologyPlasma;

    @FindBy(xpath = "//h3[text()='Price']")
    public WebElement labelPrice;

    @FindBy(xpath = "//input[@aria-label='Minimum Value in $']")
    public WebElement textFieldPriceMin;

    public PageSearchResults(WebDriver driver) {
        super(driver);
    }


}
