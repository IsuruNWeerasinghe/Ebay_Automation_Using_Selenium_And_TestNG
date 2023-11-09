package pom.test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pom.pages.PageBase;
import pom.pages.PageEbayHome;
import pom.pages.categories.PageSelectedSubCategory;
import pom.utils.TestNGUtil;

public class TestHomePageAndNavigateThroughMenus extends TestNGUtil {
    private PageEbayHome pageEbayHome;

    @Test
    public void testHomePage(){
        //Initiating report.
        extentTest = extent.createTest("Test 1: Test Homepage visibility.").assignAuthor("Isuru Weerasinghe");
        extentTest.log(Status.INFO,"Test 1: Started");

        //Opening browser and navigating to EBay homepage.
        PageBase pageBase = PageFactory.initElements(browserFactoryInstance.getDriver(), PageBase.class);
        pageEbayHome = pageBase.openApplication();
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.logo));
        extentTest.log(Status.PASS,"Test 1: Ebay homepage opened successfully.");
    }

    @Test(dependsOnMethods = "testHomePage")
    public void testTopMenuBarMouseHoverFunction(){
        //Initiating report.
        extentTest = extent.createTest("Test 2: Test top menu bar and mouse hovering functions.").assignAuthor("Isuru Weerasinghe");
        extentTest.log(Status.INFO,"Test 2: Started");
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.logo));

        //Checking mouse hovering function for Electronics menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarElectronics);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemSamsungInElectronicsMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemSamsungInElectronicsMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Electronics item.");

        //Checking mouse hovering function for Motors menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarMotors);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemAutoAndTruckPartsInMotorsMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemAutoAndTruckPartsInMotorsMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Motors item.");

        //Checking mouse hovering function for Fashion menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarFashion);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemFootwearInFashionMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemFootwearInFashionMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Fashion item.");

        //Checking mouse hovering function for Collectibles And Art menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarCollectiblesAndArt);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemAntiquesInCollectiblesAndArtMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemAntiquesInCollectiblesAndArtMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Collectibles And Art item.");

        //Checking mouse hovering function for Sports menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarSports);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemCampingInSportsMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemCampingInSportsMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Sports item.");

        //Checking mouse hovering function for Health And Beauty menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarHealthAndBeauty);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemHairProductsInHealthAndBeautyMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemHairProductsInHealthAndBeautyMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Health And Beauty item.");

        //Checking mouse hovering function for Industrial Equipment menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarIndustrialEquipment);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemMaintenanceAndSafetyInIndustrialEquipmentMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemMaintenanceAndSafetyInIndustrialEquipmentMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Industrial Equipment item.");

        //Checking mouse hovering function for Home And Garden menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarHomeAndGarden);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemPetsInHomeAndGardenMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemPetsInHomeAndGardenMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Home And Garden item.");

        //Checking mouse hovering function for Sell menu item.
        pageEbayHome.hoverMouseToElement(pageEbayHome.topMenuBarSell);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageEbayHome.itemSellerCenterInSellMenu));
        pageEbayHome.clickOnElementAndOpenNewPage(pageEbayHome.itemSellerCenterInSellMenu, PageSelectedSubCategory.class);
        browserFactoryInstance.getDriver().navigate().back();
        extentTest.log(Status.INFO,"Test 2: Mouse hovering function works properly for Sell item.");

        extentTest.log(Status.PASS,"Test 2: Mouse hovering function works properly for top menu bar.");
    }

}
