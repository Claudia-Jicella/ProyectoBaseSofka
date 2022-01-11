package co.com.client.webproject.test.controllers.shoppingcart;

import co.com.client.webproject.test.models.ProductModel;
import co.com.client.webproject.test.page.shoppingcart.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class ShoppingCartWebController {

    private WebAction webAction;
    private ProductModel productModel;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreYPrecioEnElCarrito(){
        String cartInfo = "Name: %s. Price: %s";
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            productModel = new ProductModel();

            webAction.scroll(100);
            productModel.setProdName(webAction.getText(shoppingCartPage.getCartProductName(), SHORT_WAIT.getValue(), true));
            productModel.setProdPrice(webAction.getText(shoppingCartPage.getCartProductPrice(), SHORT_WAIT.getValue(), true));

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar al obtener la información en el carrito.", e);
        }

        return String.format(cartInfo, productModel.getProdName(), productModel.getProdPrice());
    }
}
