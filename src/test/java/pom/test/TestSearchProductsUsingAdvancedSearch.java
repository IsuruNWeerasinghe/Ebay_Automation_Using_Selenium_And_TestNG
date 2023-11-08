package pom.test;

import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.pages.*;
import pom.testUtils.TestNGUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TestSearchProductsUsingAdvancedSearch extends TestNGUtil {

    private final static String ITEMS_LIST_EXCEL_FILE_NAME_AND_FILE_PATH = "Items_list.xlsx";
    private final static String ITEMS_LIST_EXCEL_FILE_SHEET_NAME = "Sheet1";

    private PageEbayHome pageEBayHome;
    private PageSearchResults pageSearchResults;
    private PageShoppingCart pageShoppingCart;


    @DataProvider
    public Object[][] readExcelFile(){
        String searchValue = null;
        String keywordOptions = null;
        String category = null;
        String minPrice = null;
        String maxPrice = null;
        String buyingFormat = null;
        String condition = null;
        String showResults = null;
        String multipleItemsMinQuantity = null;
        String multipleItemsMaxQuantity = null;
        String shippingOptions = null;
        String itemLocation = null;
        String sortBy = null;
        String resultsPerPage = null;

        Object[][] data;

        InputStream inputStream;
        try {
            inputStream = new FileInputStream(ITEMS_LIST_EXCEL_FILE_NAME_AND_FILE_PATH);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(ITEMS_LIST_EXCEL_FILE_SHEET_NAME);

            DataFormatter dataFormatter= new DataFormatter();

            data = new Object[xssfSheet.getLastRowNum()][xssfSheet.getDimension().getLastColumn() + 1];
            int dataCount = 0;

            for(int i=0; i<= xssfSheet.getLastRowNum(); i++){
                if(i==0){continue;}

                XSSFRow xssfRow = xssfSheet.getRow(i);

                searchValue = dataFormatter.formatCellValue(xssfRow.getCell(0));
                keywordOptions = dataFormatter.formatCellValue(xssfRow.getCell(1));
                category = dataFormatter.formatCellValue(xssfRow.getCell(2));
                minPrice = dataFormatter.formatCellValue(xssfRow.getCell(3));
                maxPrice = dataFormatter.formatCellValue(xssfRow.getCell(4));
                buyingFormat = dataFormatter.formatCellValue(xssfRow.getCell(5));
                condition = dataFormatter.formatCellValue(xssfRow.getCell(6));
                showResults = dataFormatter.formatCellValue(xssfRow.getCell(7));
                multipleItemsMinQuantity = dataFormatter.formatCellValue(xssfRow.getCell(8));
                multipleItemsMaxQuantity = dataFormatter.formatCellValue(xssfRow.getCell(9));
                shippingOptions = dataFormatter.formatCellValue(xssfRow.getCell(10));
                itemLocation = dataFormatter.formatCellValue(xssfRow.getCell(11));
                sortBy = dataFormatter.formatCellValue(xssfRow.getCell(12));
                resultsPerPage = dataFormatter.formatCellValue(xssfRow.getCell(13));

                data[dataCount][0] = searchValue;
                data[dataCount][1] = keywordOptions;
                data[dataCount][2] = category;
                data[dataCount][3] = minPrice;
                data[dataCount][4] = maxPrice;
                data[dataCount][5] = buyingFormat;
                data[dataCount][6] = condition;
                data[dataCount][7] = showResults;
                data[dataCount][8] = multipleItemsMinQuantity;
                data[dataCount][9] = multipleItemsMaxQuantity;
                data[dataCount][10] = shippingOptions;
                data[dataCount][11] = itemLocation;
                data[dataCount][12] = sortBy;
                data[dataCount][13] = resultsPerPage;

                dataCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Test(dataProvider = "readExcelFile")
    public void testProductsSearchUsingAdvancedSearch(String searchValue, String keywordOptions, String category,
                                                      String minPrice, String maxPrice, String buyingFormat, String condition,
                                                      String showResults, String multipleItemsMinQuantity, String multipleItemsMaxQuantity,
                                                      String shippingOptions, String itemLocation, String sortBy, String resultsPerPage) {

        //Initiating report.
        extentTest = extent.createTest("Test Case 1: Search Products in Advanced Search")
                .assignAuthor("Isuru Weerasinghe");
        extentTest.log(Status.INFO,"Test Case 1: Started");

        //Opening browser and navigating to EBay homepage.
        PageBase pageBase = PageFactory.initElements(browserFactoryInstance.getDriver(), PageBase.class);
        pageEBayHome = pageBase.openApplication();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEBayHome.topNavigationSportsItem));
        extentTest.log(Status.INFO,"Test Case 1: Ebay homepage opened.");

        //Navigating to Advanced Search page.
        PageAdvanceSearch pageAdvanceSearch = pageEBayHome.clickAdvancedSearchButton();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageAdvanceSearch.textFieldKeywordsOrItemNumber));
        extentTest.log(Status.INFO,"Test Case 1: Navigated to the Advanced Search.");

        //Adding searching criteria according to the given excel file.
        if(!searchValue.isEmpty()) pageAdvanceSearch.typeOnEnterKeywords(searchValue);
        if(!keywordOptions.isEmpty()) pageAdvanceSearch.selectKeywordOptions(keywordOptions);
        if(!category.isEmpty()) pageAdvanceSearch.selectCategory(category);

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.textFieldMaxPrice);
        if(!minPrice.isEmpty())pageAdvanceSearch.addMinPrice(minPrice);
        if(!maxPrice.isEmpty()) pageAdvanceSearch.addMaxPrice(maxPrice);

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.radioButtonBuyingFormatAcceptsOffers);
        switch (buyingFormat){
            case "Accepts offers" :
                pageAdvanceSearch.clickOnBuyingFormatAcceptOffers();
                break;

            case "Buy It Now" :
                pageAdvanceSearch.clickOnBuyingFormatBuyItNow();
                break;

            default:
                break;
        }

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.radioButtonConditionNew);
        switch (condition){
            case "New" :
                pageAdvanceSearch.clickOnConditionNew();
                break;

            case "Used" :
                pageAdvanceSearch.clickOnConditionUsed();
                break;

            case "Not specified" :
                pageAdvanceSearch.clickOnConditionNotSpecified();
                break;

            default:
                break;
        }

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.checkBoxShowResultsAuthorizedSeller);
        switch (showResults){
            case "Authorized seller" :
                pageAdvanceSearch.clickOnShowResultsAuthorizedSeller();
                break;

            case "Returns accepted" :
                pageAdvanceSearch.clickOnShowResultsReturnsAccepted();
                break;

            case "Sale items" :
                pageAdvanceSearch.clickOnShowResultsSaleItems();
                break;

            case "Deals and savings" :
                pageAdvanceSearch.clickOnShowResultsDealsAndSavings();
                break;

            default:
                break;
        }

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.textFieldMultipleItemsMinQuantity);
        if(!multipleItemsMinQuantity.isEmpty()) pageAdvanceSearch.addMultipleItemsMinQuantity(minPrice);
        if(!multipleItemsMaxQuantity.isEmpty()) pageAdvanceSearch.addMultipleItemsMaxQuantity(maxPrice);

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.checkBoxShippingOptionsFreeShipping);
        switch (shippingOptions){
            case "Free shipping" :
                pageAdvanceSearch.clickOnShippingOptionsFreeShipping();
                break;

            case "Local pickup" :
                pageAdvanceSearch.clickOnShippingOptionsLocalPickup();
                break;

            default:
                break;

        }

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.radioButtonItemLocationWorldwide);
        switch (itemLocation){
            case "Worldwide" :
                pageAdvanceSearch.clickOnItemLocationWorldwide();
                break;

            case "US Only" :
                pageAdvanceSearch.clickOnItemLocationUsOnly();
                break;

            case "North America" :
                pageAdvanceSearch.clickOnItemLocationNorthAmerica();
                break;

            default:
                break;

        }

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.dropdownSortBy);
        if(!sortBy.isEmpty()) pageAdvanceSearch.selectSortBy(sortBy);
        if(!resultsPerPage.isEmpty()) pageAdvanceSearch.selectResultsPerPage(resultsPerPage);

        pageAdvanceSearch.scrollPageToElement(pageAdvanceSearch.buttonSearch);
        extentTest.log(Status.INFO,"Test Case 1: Searching criteria added.");

        //Clicking "Search" button for search item.
        pageSearchResults = pageAdvanceSearch.clickSearchButton();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageSearchResults.firstElementSearchResults));
        extentTest.log(Status.INFO,"Test Case 1: Search results page opened.");

        //Clicking on first item of the search results.
        PageSelectedSearchItem pageSelectedSearchItem = pageSearchResults.clickFirstSearchElement();
        extentTest.log(Status.INFO,"Test Case 1: First item has selected from the search results.");

        //Make newly opened tab as the active window.
        ArrayList<String> currentURL = new ArrayList<String>(browserFactoryInstance.getDriver().getWindowHandles());
        browserFactoryInstance.getDriver().switchTo().window(currentURL.get(1));
        webDriverWait.until(ExpectedConditions.visibilityOf(pageSelectedSearchItem.buttonAddToCart));

        //Clicking "Add To Cart" button.
        pageShoppingCart = pageSelectedSearchItem.clickAddToCartButton();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageShoppingCart.labelShoppingCart));
        extentTest.log(Status.INFO,"Test Case 1: Shopping cart page opened.");

        //Closing the "Shopping Cart" page.
        browserFactoryInstance.getDriver().switchTo().window(currentURL.get(1)).close();

        //Making "Search Results" page active window.
        browserFactoryInstance.getDriver().switchTo().window(currentURL.get(0));
        webDriverWait.until(ExpectedConditions.visibilityOf(pageSearchResults.labelSearchResults));
        extentTest.log(Status.INFO,"Test Case 1: Shopping cart page has closed. Item has successfully added to the cart.");
        extentTest.log(Status.PASS,"Test Case 1: Passed Successfully.");
    }

    @Test(dependsOnMethods = "testProductsSearchUsingAdvancedSearch")
    public void testItemsInShoppingCart() {
        extentTest = extent.createTest("Test Case 2: Open shopping cart and view Total Price, Shipping Charge and Sub Total")
                .assignAuthor("Isuru Weerasinghe");

        //Clicking on "Shopping Cart" icon in top right corner.
        pageShoppingCart = pageSearchResults.clickShoppingCartIcon();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageShoppingCart.labelShoppingCart));
        extentTest.log(Status.INFO,"Test Case 2: Shopping cart page has opened.");

        //Getting prices in "Shopping Cart" page.
        String totalPrice = pageShoppingCart.getTotalPrice();
        String shippingPrice = pageShoppingCart.getShippingPrice();
        String subTotal = pageShoppingCart.getSubTotal();

        extentTest.log(Status.INFO,"Test Case 2: Total Price for selected items : " + totalPrice);
        extentTest.log(Status.INFO,"Test Case 2: Shipping charge : " + shippingPrice);
        extentTest.log(Status.INFO,"Test Case 2: Sub Total : " + subTotal);
        extentTest.log(Status.PASS,"Test Case 2: Passed Successfully.");
    }

}
