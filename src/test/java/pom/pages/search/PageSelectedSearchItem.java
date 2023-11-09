package pom.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.pages.PageBase;
import pom.pages.shoppingCart.PageShoppingCart;

public class PageSelectedSearchItem extends PageBase {

    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement buttonAddToCart;

    public PageSelectedSearchItem(WebDriver driver) {
        super(driver);
    }

}
