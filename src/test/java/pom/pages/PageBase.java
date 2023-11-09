package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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


    //Method for hovering mouse to element.
    public void hoverMouseToElement(WebElement element){new Actions(driver).moveToElement(element).perform();}


    //Method for navigating web page according to the clicked element.
    public <T> T clickOnElementAndOpenNewPage(WebElement element, Class<T> t){
        element.click();
        return PageFactory.initElements(driver, t);
    }


    //Method for clicking on button..
    public void clickOnButton(WebElement element){
        element.click();
    }


    //Method for type in text fields.
    public void typeOnTextField(WebElement element, String text){
        element.sendKeys(text);
    }


    //Method for click in check boxes or radio buttons.
    public void clickOnCheckboxOrRadioButton(WebElement element){
        element.click();
    }


    //Method for select item from dropdown.
    public void selectDropdownValue(WebElement element, String keywordText){
        new Select(element).selectByVisibleText(keywordText);
    }

    //Method for getting text of the web element.
    public String getTextOfElement(WebElement element){
        return element.getText();
    }

}
