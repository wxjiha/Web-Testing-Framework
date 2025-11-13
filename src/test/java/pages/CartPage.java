package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://demoblaze.com/cart.html")
public class CartPage extends PageObject {
    @FindBy(css = ".btn.btn-success")
    private WebElementFacade placeOrderButton;
    public void clickPlaceOrder() {
        placeOrderButton.click();

    }
}
