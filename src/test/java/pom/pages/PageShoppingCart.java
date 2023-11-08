package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageShoppingCart extends PageBase{

    @FindBy(xpath = "//h1[@data-test-id='main-title']")
    public WebElement labelShoppingCart;

    @FindBy(xpath = "//div[@data-test-id='ITEM_TOTAL']//span//span/span")
    public WebElement labelTotalPrice;

    @FindBy(xpath = "//div[@data-test-id='SHIPPING']//span//span/span")
    public WebElement labelShippingPrice;

    @FindBy(xpath = "//div[@data-test-id='SUBTOTAL']//span//span/span")
    public WebElement labelSubTotal;

    public PageShoppingCart(WebDriver driver) {
        super(driver);
    }

    public String getTotalPrice(){
        return labelTotalPrice.getText();
    }

    public String getShippingPrice(){
        return labelShippingPrice.getText();
    }

    public String getSubTotal(){
        return labelSubTotal.getText();
    }
}
