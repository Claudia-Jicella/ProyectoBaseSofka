package co.com.client.webproject.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @CacheLookup
    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='1']")
    WebElement addFirstProduct;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    WebElement firstProductName;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span")
    WebElement firstProductPrice;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement checkoutButton;

    public WebElement getAddFirstProduct() {
        return addFirstProduct;
    }

    public WebElement getFirstProductName() {
        return firstProductName;
    }

    public WebElement getFirstProductPrice() {
        return firstProductPrice;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public ProductPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
