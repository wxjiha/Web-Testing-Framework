package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DefaultUrl("https://demoblaze.com/cart.html")
public class CheckoutPage extends PageObject {

    @FindBy(id = "tbodyid")
    private WebElementFacade cartTable;

    @FindBy(id = "totalp")
    private WebElementFacade totalPrice;

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


    public List<WebElement> getCartItems(){
        return cartTable.findElements(By.className("success"));
    }

    public void clickSpecifiedDeleteButton(int index){
        WebElement cartItem = getCartItems().get(index);
        WebElement deleteCell = cartItem.findElements(By.tagName("td")).get(3);
        WebElement deleteBtn = deleteCell.findElement(By.tagName("a"));
        deleteBtn.click();
    }

    public void clickFirstDeleteButton(){
        clickSpecifiedDeleteButton(0);
    }

    public void waitForCartToBeEmpty() {
        //Note: Serenity/Selenium is annoying and this will run for like 15 seconds or w/ever the default wait time is
        waitForCondition().until(ExpectedConditions.numberOfElementsToBe(By.className("success"), 0));
    }

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

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
