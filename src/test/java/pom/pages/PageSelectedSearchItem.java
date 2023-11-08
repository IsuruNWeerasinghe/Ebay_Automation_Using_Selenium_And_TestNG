package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSelectedSearchItem extends PageBase{

    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement buttonAddToCart;

    public PageSelectedSearchItem(WebDriver driver) {
        super(driver);
    }

    public PageShoppingCart clickAddToCartButton(){
        buttonAddToCart.click();
        return PageFactory.initElements(driver, PageShoppingCart.class);
    }
}
