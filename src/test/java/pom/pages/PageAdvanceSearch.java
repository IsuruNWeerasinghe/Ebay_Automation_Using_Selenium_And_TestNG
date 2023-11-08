package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageAdvanceSearch extends PageBase{

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



    //Method for typing Keywords or Item Number in text field.
    public void typeOnEnterKeywords(String keywords){
        textFieldKeywordsOrItemNumber.sendKeys(keywords);
    }


    //Method for selecting Keyword options dropdown value.
    public void selectKeywordOptions(String keywordText){
        new Select(dropdownKeywordOptions).selectByVisibleText(keywordText);
    }


    //Method for selecting Category dropdown value.
    public void selectCategory(String categoryText){
        new Select(dropdownInThisCategory).selectByVisibleText(categoryText);
    }


    //Method for typing Price in text field.
    public void addMinPrice(String price){textFieldMinPrice.sendKeys(price);}
    public void addMaxPrice(String price){textFieldMaxPrice.sendKeys(price);}


    //Method for clicking Buying Format radio button.
    public void clickOnBuyingFormatAcceptOffers(){radioButtonBuyingFormatAcceptsOffers.click();}
    public void clickOnBuyingFormatBuyItNow(){radioButtonBuyingFormatBuyItNow.click();}


    //Method for clicking Condition radio button.
    public void clickOnConditionNew(){
        radioButtonConditionNew.click();
    }
    public void clickOnConditionNotSpecified(){radioButtonConditionNotSpecified.click();}
    public void clickOnConditionUsed(){radioButtonConditionUsed.click();}


    //Method for clicking Show Results checkboxes.
    public void clickOnShowResultsAuthorizedSeller(){
        checkBoxShowResultsAuthorizedSeller.click();
    }
    public void clickOnShowResultsReturnsAccepted(){
        checkBoxShowResultsReturnsAccepted.click();
    }
    public void clickOnShowResultsSaleItems(){
        checkBoxShowResultsSaleItems.click();
    }
    public void clickOnShowResultsDealsAndSavings(){checkBoxShowResultsDealsAndSavings.click();}


    //Method for typing Multiple items from text field.
    public void addMultipleItemsMinQuantity(String quantity){textFieldMultipleItemsMinQuantity.sendKeys(quantity);}
    public void addMultipleItemsMaxQuantity(String quantity){textFieldMultipleItemsMaxQuantity.sendKeys(quantity);}


    //Method for clicking Shipping Options checkboxes.
    public void clickOnShippingOptionsFreeShipping(){
        checkBoxShippingOptionsFreeShipping.click();
    }
    public void clickOnShippingOptionsLocalPickup(){
        checkBoxShippingOptionsLocalPickup.click();
    }


    //Method for clicking Item Location radio button.
    public void clickOnItemLocationWorldwide(){
        radioButtonItemLocationWorldwide.click();
    }
    public void clickOnItemLocationUsOnly(){
        radioButtonItemLocationUsOnly.click();
    }
    public void clickOnItemLocationNorthAmerica(){
        radioButtonItemLocationNorthAmerica.click();
    }


    //Method for selecting Sort By dropdown value.
    public void selectSortBy(String sortBy){
        new Select(dropdownSortBy).selectByVisibleText(sortBy);
    }


    //Method for selecting Results Per Page dropdown value.
    public void selectResultsPerPage(String resultsPerPage){new Select(dropdownResultsPerPage).selectByVisibleText(resultsPerPage);}

    //Method for clicking Search button.
    public PageSearchResults clickSearchButton(){
        buttonSearch.click();
        return PageFactory.initElements(driver, PageSearchResults.class);
    }

}
