package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.pages.search.PageAdvanceSearch;

public class PageEbayHome extends PageBase{

    @FindBy(xpath = "//img[@id='gh-logo']")
    public WebElement logo;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Electronics']")
    public WebElement topMenuBarElectronics;

    @FindBy(xpath = "//a[text()='Electronics']/..//a[text()='Samsung']")
    public WebElement itemSamsungInElectronicsMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Motors']")
    public WebElement topMenuBarMotors;

    @FindBy(xpath = "//a[text()='Motors']/..//a[text()='Auto and truck parts']")
    public WebElement itemAutoAndTruckPartsInMotorsMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Fashion']")
    public WebElement topMenuBarFashion;

    @FindBy(xpath = "//a[text()='Fashion']/..//a[text()='Footwear']")
    public WebElement itemFootwearInFashionMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Collectibles and Art']")
    public WebElement topMenuBarCollectiblesAndArt;

    @FindBy(xpath = "//a[text()='Collectibles and Art']/..//a[text()='Antiques']")
    public WebElement itemAntiquesInCollectiblesAndArtMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Sports']")
    public WebElement topMenuBarSports;

    @FindBy(xpath = "//a[text()='Sports']/..//a[text()='Camping']")
    public WebElement itemCampingInSportsMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Health & Beauty']")
    public WebElement topMenuBarHealthAndBeauty;

    @FindBy(xpath = "//a[text()='Health & Beauty']/..//a[text()='Hair products']")
    public WebElement itemHairProductsInHealthAndBeautyMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Industrial equipment']")
    public WebElement topMenuBarIndustrialEquipment;

    @FindBy(xpath = "//a[text()='Industrial equipment']/..//a[text()='Maintenance and safety']")
    public WebElement itemMaintenanceAndSafetyInIndustrialEquipmentMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Home & Garden']")
    public WebElement topMenuBarHomeAndGarden;

    @FindBy(xpath = "//a[text()='Home & Garden']/..//a[text()='Pets']")
    public WebElement itemPetsInHomeAndGardenMenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Sell']")
    public WebElement topMenuBarSell;

    @FindBy(xpath = "//a[text()='Sell']/..//a[text()='Seller center']")
    public WebElement itemSellerCenterInSellMenu;

    @FindBy(xpath = "//a[@id='gh-as-a']")
    public WebElement buttonAdvanced;

    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement buttonSearch;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement textFieldSearch;

    public PageEbayHome(WebDriver driver) {
        super(driver);
    }

}

