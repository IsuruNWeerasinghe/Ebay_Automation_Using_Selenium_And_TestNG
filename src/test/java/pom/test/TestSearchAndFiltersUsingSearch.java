package pom.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pom.pages.PageBase;
import pom.pages.PageEbayHome;
import pom.pages.search.PageSearchResults;
import pom.pages.search.PageSelectedSearchItem;
import pom.pages.shoppingCart.PageShoppingCart;
import pom.utils.TestNGUtil;

import java.util.ArrayList;

public class TestSearchAndFiltersUsingSearch extends TestNGUtil {

    @Test
    public void testSearchFunction() {
        //Opening browser and navigating to EBay homepage.
        PageBase pageBase = PageFactory.initElements(browserFactoryInstance.getDriver(), PageBase.class);
        PageEbayHome pageEbayHome = pageBase.openApplication();

        //Typing on search field.
        pageEbayHome.typeOnTextField(pageEbayHome.textFieldSearch, "TV" );

        //Clicking search button.
        PageSearchResults pageSearchResults = pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.buttonSearch, PageSearchResults.class);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageSearchResults.firstElementSearchResults));

        //Scrolling page until Brand label is visible.
        pageSearchResults.scrollPageToElement(pageSearchResults.labelBrand);
        //Filtering search results by Brand -Samsung.
        pageSearchResults.clickOnCheckboxOrRadioButton(pageSearchResults.checkBoxBrandSamsung);
        //Filtering search results by Brand -LG.
        pageSearchResults.clickOnCheckboxOrRadioButton(pageSearchResults.checkBoxBrandLG);

        //Scrolling page until Display Technology label is visible.
        pageSearchResults.scrollPageToElement(pageSearchResults.labelDisplayTechnology);
        //Filtering search results by Display Technology -Plasma.
        pageSearchResults.clickOnCheckboxOrRadioButton(pageSearchResults.checkBoxDisplayTechnologyPlasma);

        //Scrolling page until Price label is visible.
        pageSearchResults.scrollPageToElement(pageSearchResults.labelPrice);
        //Filtering search results by min price - $200.
        pageSearchResults.typeOnTextField(pageSearchResults.textFieldPriceMin, "200");

        //Click on first element of the search results.
        PageSelectedSearchItem pageSelectedSearchItem = pageSearchResults.clickOnElementAndOpenNewPage(pageSearchResults.firstElementSearchResults, PageSelectedSearchItem.class);

        //Make newly opened tab as the active window.
        ArrayList<String> currentURL = new ArrayList<String>(browserFactoryInstance.getDriver().getWindowHandles());
        browserFactoryInstance.getDriver().switchTo().window(currentURL.get(1));

        //Click on Add to Cart button.
        PageShoppingCart pageShoppingCart = pageSelectedSearchItem.clickOnElementAndOpenNewPage(pageSelectedSearchItem.buttonAddToCart, PageShoppingCart.class);

        //Click on Go To Checkout button
        pageShoppingCart.clickOnButton(pageShoppingCart.buttonGoToCheckout);
    }
}
