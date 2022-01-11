package co.com.client.webproject.test.stepdefinition;


import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;


public class GeneralSetup {

    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(true);

        //browserConfiguration.setDriverVersion("95.0.4638.69");

        browserConfiguration.setChromeOptions(chromeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
