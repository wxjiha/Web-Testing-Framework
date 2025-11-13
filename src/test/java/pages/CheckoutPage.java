package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://demoblaze.com/cart.html")
public class CheckoutPage extends PageObject {

    @FindBy(css = ".btn.btn-success")
    private WebElementFacade placeOrderBtn;

    @FindBy(id = "name")
    private WebElementFacade nameField;
    @FindBy(id = "country")
    private WebElementFacade countryField;
    @FindBy(id = "city")
    private WebElementFacade cityField;
    @FindBy(id = "card")
    private WebElementFacade creditCardField;
    @FindBy(id = "month")
    private WebElementFacade monthField;
    @FindBy(id = "year")
    private WebElementFacade yearField;

    @FindBy(css = "#orderModal .btn-primary")
    private WebElementFacade purchaseBtn;

    @FindBy(className = "sweet-alert")
    private WebElementFacade thankYouMessage;

    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }

    public void enterName(String name) { nameField.type(name); }
    public void enterCountry(String country) { countryField.type(country); }
    public void enterCity(String city) { cityField.type(city); }
    public void enterCreditCard(String card) { creditCardField.type(card); }
    public void enterMonth(String month) { monthField.type(month); }
    public void enterYear(String year) { yearField.type(year); }

    public void clickPurchaseBtn() {
        purchaseBtn.click();
    }

    public boolean isThankYouMessageDisplayed() {
        return thankYouMessage.isCurrentlyVisible();
    }

    public String thankYouOrderMessage() {
        return thankYouMessage.getText();
    }
    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

}
