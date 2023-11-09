package pom.pages.shoppingCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.pages.PageBase;

public class PageShoppingCart extends PageBase {

    @FindBy(xpath = "//h1[@data-test-id='main-title']")
    public WebElement labelShoppingCart;

    @FindBy(xpath = "//div[@data-test-id='ITEM_TOTAL']//span//span/span")
    public WebElement labelTotalPrice;

    @FindBy(xpath = "//div[@data-test-id='SHIPPING']//span//span/span")
    public WebElement labelShippingPrice;

    @FindBy(xpath = "//div[@data-test-id='SUBTOTAL']//span//span/span")
    public WebElement labelSubTotal;

    @FindBy(xpath = "//button[@data-test-id='cta-top']")
    public WebElement buttonGoToCheckout;

    public PageShoppingCart(WebDriver driver) {
        super(driver);
    }

}
