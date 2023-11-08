package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchResults extends PageBase{

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[@class='s-item s-item__pl-on-bottom'][1]//div[@class='s-item__image-section']")
    public WebElement firstElementSearchResults;

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']")
    public WebElement labelSearchResults;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a")
    public WebElement iconShoppingCart;


    public PageSearchResults(WebDriver driver) {
        super(driver);
    }

    public PageSelectedSearchItem clickFirstSearchElement(){
        firstElementSearchResults.click();
        return PageFactory.initElements(driver, PageSelectedSearchItem.class);
    }

    public PageShoppingCart clickShoppingCartIcon(){
        iconShoppingCart.click();
        return PageFactory.initElements(driver, PageShoppingCart.class);
    }

}
