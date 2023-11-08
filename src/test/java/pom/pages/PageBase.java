package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    //Method for opening eBay home page.
    public PageEbayHome openApplication(){
        driver.get("https://www.ebay.com/");
        return PageFactory.initElements(driver, PageEbayHome.class);
    }


    //Method for scrolling page by pixels.
    public void scrollPageByPixel(int x, int y){
        new Actions(driver).scrollByAmount(x, y).perform();
    }


    //Method for scrolling page until element is visible.
    public void scrollPageToElement(WebElement element){
        new Actions(driver).scrollToElement(element).perform();
    }

}
