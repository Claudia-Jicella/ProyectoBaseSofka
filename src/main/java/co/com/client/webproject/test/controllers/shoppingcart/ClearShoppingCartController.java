package co.com.client.webproject.test.controllers.shoppingcart;

import co.com.client.webproject.test.page.shoppingcart.DeleteProductPage;
import co.com.client.webproject.test.page.shoppingcart.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class ClearShoppingCartController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void limpiarElCarrito(){
        try{
            DeleteProductPage deleteProductPage = new DeleteProductPage(webAction.getDriver());

            webAction.scroll(100);
            webAction.click(deleteProductPage.getCartProductDelete(), SHORT_WAIT.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar vaciar el carrito.", e);
        }
    }
}
