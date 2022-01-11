package co.com.client.webproject.test.controllers.contactus;

import co.com.client.webproject.test.models.ContactUsModel;
import co.com.client.webproject.test.page.contactus.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Subject.CUSTOMERSERVICE;
import static co.com.client.webproject.test.utils.Waits.MIN_WAIT;
import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class ContactUsWebController {

    private WebAction webAction;
    private ContactUsModel contactUsModel;

    public ContactUsModel getContactUsModel() {
        return contactUsModel;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void enviarMensajeAContactanos(ContactUsModel contactUs){
        try {
            contactUsModel = contactUs;
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            if (contactUsModel.getSubject().equals(CUSTOMERSERVICE.getValue())){
                webAction.click(contactUsPage.getCustomerServiceOption(), SHORT_WAIT.getValue(), true);
            } else{
                webAction.click(contactUsPage.getWebmasterOption(), SHORT_WAIT.getValue(), true);
            }

            webAction.sendText(contactUsPage.getEmailField(), contactUsModel.getEmail(), true);
            webAction.sendText(contactUsPage.getOrderField(), contactUsModel.getReference(), true);
            webAction.sendText(contactUsPage.getMessageField(), contactUsModel.getMessage(), true);

            webAction.click(contactUsPage.getSubmitButton(), MIN_WAIT.getValue(), true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }

}
