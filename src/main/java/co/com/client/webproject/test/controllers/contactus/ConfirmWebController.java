package co.com.client.webproject.test.controllers.contactus;

import co.com.client.webproject.test.page.contactus.ContactUsMessagePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class ConfirmWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerAlertaExitosa(){
        String alerta = "";
        try {
            ContactUsMessagePage contactUsMessagePage = new ContactUsMessagePage(webAction.getDriver());
            alerta = webAction.getText(contactUsMessagePage.getSuccessAlert(), SHORT_WAIT.getValue(), true);

        }catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar el envío del mensaje.", e);
        }
        return alerta;
    }
}
