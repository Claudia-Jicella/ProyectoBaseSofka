package co.com.client.webproject.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsMessagePage {

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successAlert;

    public WebElement getSuccessAlert() {
        return successAlert;
    }

    public ContactUsMessagePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
