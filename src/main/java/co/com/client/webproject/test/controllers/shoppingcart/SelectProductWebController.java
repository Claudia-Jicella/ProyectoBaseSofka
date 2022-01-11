package co.com.client.webproject.test.controllers.shoppingcart;

import co.com.client.webproject.test.models.ProductModel;
import co.com.client.webproject.test.page.shoppingcart.ProductPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.MIN_WAIT;
import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class SelectProductWebController {


    private WebAction webAction;
    private ProductModel productModel;

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void seleccionarProducto(){
        try{
            ProductPage productPage = new ProductPage(webAction.getDriver());
            productModel = new ProductModel();

            productModel.setProdName(webAction.getText(productPage.getFirstProductName(), SHORT_WAIT.getValue(), true));
            productModel.setProdPrice(webAction.getText(productPage.getFirstProductPrice(), SHORT_WAIT.getValue(),true));

            webAction.clickNotVisible(productPage.getAddFirstProduct(), SHORT_WAIT.getValue(), true);
            webAction.click(productPage.getCheckoutButton(), SHORT_WAIT.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar seleccionar el producto.", e);
        }
    }
}
