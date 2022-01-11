package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.contactus.ConfirmWebController;
import co.com.client.webproject.test.controllers.contactus.ContactUsPageWebController;
import co.com.client.webproject.test.controllers.contactus.ContactUsWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.ContactUsModel;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateEmail;
import static co.com.client.webproject.test.utils.AlertMessages.CONTACT_US_SUCCESS;
import static co.com.client.webproject.test.utils.Subject.CUSTOMERSERVICE;
import static co.com.client.webproject.test.utils.Subject.WEBMASTER;

public class ContactanosStepDefinition extends GeneralSetup{

    protected WebAction webAction = new WebAction(testInfo.getFeatureName());
    private ContactUsModel contactUsModel;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction.setScenario(testInfo.getScenarioName());
    }

    //Background
    @Given("que el cliente está en la página principal de la tienda virtual My Store")
    public void queElClienteEstaEnLaPaginaPrincipalDeLaTiendaVirtualMyStore() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    //Escenario1
    @When("selecciona Contac us la opcion Servicio al cliente e ingrese los campos obligatorios")
    public void seleccionaContacUsLaOpcionServicioAlClienteEIngreseLosCamposObligatorios() {
        ContactUsPageWebController contactUsPageWebController = new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();

        generateContactUsModel(
                CUSTOMERSERVICE.getValue(),
                generateEmail(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN),
                "12345hhc",
                "Solicitud de factura"
        );

        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.enviarMensajeAContactanos(contactUsModel);
    }

    @Then("el sistema debera mostrar un mensaje de confimacion de envio de la solicitud")
    public void elSistemaDeberaMostrarUnMensajeDeConfimacionDeEnvioDeLaSolicitud() {
        ConfirmWebController confirmWebController = new ConfirmWebController();
        confirmWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(confirmWebController.obtenerAlertaExitosa())
                .isEqualTo(CONTACT_US_SUCCESS.getValue());
    }

    //Escenario 2
    @When("seleccione Contac us la opcion Webmaster e ingrese los campos obligatorios")
    public void seleccioneContacUsLaOpcionWebmasterEIngreseLosCamposObligatorios() {
        ContactUsPageWebController contactUsPageWebController = new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();

        generateContactUsModel(
                WEBMASTER.getValue(),
                generateEmail(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN),
                "774626egdhk",
                "pedido"
        );

        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.enviarMensajeAContactanos(contactUsModel);
    }
    @Then("la pagina debera imprimir en pantalla la confirmacion de la solicitud")
    public void laPaginaDeberaImprimirEnPantallaLaConfirmacionDeLaSolicitud() {
        ConfirmWebController confirmWebController = new ConfirmWebController();
        confirmWebController.setWebAction(webAction);
        String mensaje = CONTACT_US_SUCCESS.getValue();
        Assert.Hard
                .thatString(confirmWebController.obtenerAlertaExitosa())
                .isEqualTo(mensaje);
    }

    @After
    public void tearDown() {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("Prueba terminada" + "\n"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

    private void generateContactUsModel(String subject, String email, String reference, String message){
        contactUsModel = new ContactUsModel();
        contactUsModel.setSubject(subject);
        contactUsModel.setEmail(email);
        contactUsModel.setReference(reference);
        contactUsModel.setMessage(message);
    }
}