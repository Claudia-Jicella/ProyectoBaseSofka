package co.com.client.webproject.test.controllers.contactus;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.MIN_WAIT;

public class ContactUsPageWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaContactUsPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getContactUs(), MIN_WAIT.getValue(), true);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la página contactanos.", e);
        }
    }
}
