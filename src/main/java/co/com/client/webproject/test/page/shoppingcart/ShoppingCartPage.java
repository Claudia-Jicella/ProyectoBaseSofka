package co.com.client.webproject.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @CacheLookup
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//tr[contains(@id, 'product_1_1')]//p//a")
    WebElement cartProductName;

    @CacheLookup
    @FindBy(xpath = "//tr[contains(@id, 'product_1_1')]//span[contains(@id, 'product_price_1_1')][1]//span")
    WebElement cartProductPrice;

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getCartProductName() {
        return cartProductName;
    }

    public WebElement getCartProductPrice() {
        return cartProductPrice;
    }

    public ShoppingCartPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
