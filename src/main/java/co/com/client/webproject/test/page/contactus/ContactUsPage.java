package co.com.client.webproject.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//option[text()='Customer service']")
    WebElement customerServiceOption;

    @CacheLookup
    @FindBy(xpath = "//option[text()='Webmaster']")
    WebElement webmasterOption;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orderField;

    @CacheLookup
    @FindBy(id = "message")
    WebElement messageField;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitButton;

    public WebElement getCustomerServiceOption() {
        return customerServiceOption;
    }

    public WebElement getWebmasterOption() {
        return webmasterOption;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getOrderField() {
        return orderField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public ContactUsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
