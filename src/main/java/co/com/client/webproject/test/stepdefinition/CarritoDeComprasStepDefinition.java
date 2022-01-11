package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.controllers.shoppingcart.*;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.ProductModel;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static co.com.client.webproject.test.utils.AlertMessages.EMPTY_CART;

public class CarritoDeComprasStepDefinition extends GeneralSetup{

    private WebAction webAction = new WebAction(testInfo.getFeatureName());
    private ProductModel product;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction.setScenario(testInfo.getScenarioName());
    }

    //Background
    @Given("que el cliente se encuentra en la pagina de inicio y se loggeo con exito")
    public void queElClienteSeEncuentraEnLaPaginaDeInicioYSeLoggeoConExito() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
    }

    // Escenario 1
    @When("el cliente escoge los productos que quiere comprar y los agrega al carrito")
    public void elClienteEscogeLosProductosQueQuiereComprarYLosAgregaAlCarrito() {
        ProductsPageWebController productWebController = new ProductsPageWebController();
        productWebController.setWebAction(webAction);
        productWebController.irHaciaWomenPage();

        SelectProductWebController selectProductWebController = new SelectProductWebController();
        selectProductWebController.setWebAction(webAction);
        selectProductWebController.seleccionarProducto();
        product = selectProductWebController.getProductModel();
    }
    @Then("en la pagina debera aparecer los productos escogidos en el carro")
    public void enLaPaginaDeberaAparecerLosProductosEscogidosEnElCarro() {
        ShoppingCartWebController shoppingCartWebController = new ShoppingCartWebController();
        shoppingCartWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(shoppingCartWebController.obtenerNombreYPrecioEnElCarrito())
                .isEqualTo(String.format("Name: %s. Price: %s", product.getProdName(), product.getProdPrice()));
    }

    //Escenario 2
    @When("el cliente tenga productos en el carrito y quiera borrarlos")
    public void elClienteTengaProductosEnElCarritoYQuieraBorrarlos() {
        ProductsPageWebController productWebController = new ProductsPageWebController();
        productWebController.setWebAction(webAction);
        productWebController.irHaciaWomenPage();

        SelectProductWebController selectProductWebController = new SelectProductWebController();
        selectProductWebController.setWebAction(webAction);
        selectProductWebController.seleccionarProducto();

        ClearShoppingCartController clearShoppingCartController = new ClearShoppingCartController();
        clearShoppingCartController.setWebAction(webAction);
        clearShoppingCartController.limpiarElCarrito();
    }
    @Then("en la pagina le debe aparecer el carro vacio")
    public void enLaPaginaLeDebeAparecerElCarroVacio() {
        EmptyCartWebController emptyCartWebController = new EmptyCartWebController();
        emptyCartWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(emptyCartWebController.obtenerMensajeDeCarritoVacio())
                .isEqualTo(EMPTY_CART.getValue());
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


}
