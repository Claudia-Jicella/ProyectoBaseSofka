package co.com.client.webproject.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {

    @CacheLookup
    @FindBy(xpath = "//td[@data-title='Delete']//a")
    WebElement cartProductDelete;

    public WebElement getCartProductDelete() {
        return cartProductDelete;
    }

    public DeleteProductPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
