package co.com.client.webproject.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearCartMessagePage {
    @FindBy(xpath = "//div[@id='center_column']//p")
    WebElement emptyCart;

    public WebElement getEmptyCart() {
        return emptyCart;
    }

    public ClearCartMessagePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
