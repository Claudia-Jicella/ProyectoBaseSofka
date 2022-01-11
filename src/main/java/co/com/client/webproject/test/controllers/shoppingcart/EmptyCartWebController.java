package co.com.client.webproject.test.controllers.shoppingcart;

import co.com.client.webproject.test.page.shoppingcart.ClearCartMessagePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.MID_WAIT;

public class EmptyCartWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeCarritoVacio(){
        String alerta = "";
        try {
            ClearCartMessagePage clearCartMessage = new ClearCartMessagePage((webAction.getDriver()));
            alerta = webAction.getText(clearCartMessage.getEmptyCart(), MID_WAIT.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar el envío del mensaje.", e);
        }
        return alerta;
    }


}
