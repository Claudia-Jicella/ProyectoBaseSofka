package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(css = ".login")
    WebElement signIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    WebElement contactUs;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenSection;

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getWomenSection() {
        return womenSection;
    }

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
