package pom.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pom.pages.PageBase;

public class PageAdvanceSearch extends PageBase {

    @FindBy(xpath = "//span[@class='textbox field__control textbox']/input")
    public WebElement textFieldKeywordsOrItemNumber;

    @FindBy(xpath = "//select[@name='_in_kw']")
    public WebElement dropdownKeywordOptions;

    @FindBy(xpath = "//span[@class='select']/select[@name='_sacat']")
    public WebElement dropdownInThisCategory;

    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement textFieldMinPrice;

    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement textFieldMaxPrice;

    @FindBy(xpath = "//label[text()='Accepts offers']/../span")
    public WebElement radioButtonBuyingFormatAcceptsOffers;

    @FindBy(xpath = "//label[text()='Buy It Now']/../span")
    public WebElement radioButtonBuyingFormatBuyItNow;

    @FindBy(xpath = "//label[text()='New']/../span")
    public WebElement radioButtonConditionNew;

    @FindBy(xpath = "//label[text()='Used']/../span")
    public WebElement radioButtonConditionUsed;

    @FindBy(xpath = "//label[text()='Not specified']/../span")
    public WebElement radioButtonConditionNotSpecified;

    @FindBy(xpath = "//label[text()='Authorized seller']/../span")
    public WebElement checkBoxShowResultsAuthorizedSeller;

    @FindBy(xpath = "//label[text()='Sale items']/../span")
    public WebElement checkBoxShowResultsSaleItems;

    @FindBy(xpath = "//label[text()='Returns accepted']/../span")
    public WebElement checkBoxShowResultsReturnsAccepted;

    @FindBy(xpath = "//label[text()='Deals and savings']/../span")
    public WebElement checkBoxShowResultsDealsAndSavings;

    @FindBy(xpath = "//input[@name='_samilow']")
    public WebElement textFieldMultipleItemsMinQuantity;

    @FindBy(xpath = "//input[@name='_samihi']")
    public WebElement textFieldMultipleItemsMaxQuantity;

    @FindBy(xpath = "//label[text()='Free shipping']/../span")
    public WebElement checkBoxShippingOptionsFreeShipping;

    @FindBy(xpath = "//label[text()='Local pickup']/../span")
    public WebElement checkBoxShippingOptionsLocalPickup;

    @FindBy(xpath = "//label[text()='Worldwide']/../span")
    public WebElement radioButtonItemLocationWorldwide;

    @FindBy(xpath = "//label[text()='US Only']/../span")
    public WebElement radioButtonItemLocationUsOnly;

    @FindBy(xpath = "//label[text()='North America']/../span")
    public WebElement radioButtonItemLocationNorthAmerica;

    @FindBy(xpath = "//select[@name='_sop']")
    public WebElement dropdownSortBy;
    @FindBy(xpath = "//select[@name='_ipg']")
    public WebElement dropdownResultsPerPage;

    @FindBy(xpath = "//div[@class='field adv-keywords__btn-help']/button")
    public WebElement buttonSearch;

    public PageAdvanceSearch(WebDriver driver) {
        super(driver);
    }

}
