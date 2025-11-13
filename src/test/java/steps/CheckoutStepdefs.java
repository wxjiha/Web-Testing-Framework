package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Managed;
import pages.CheckoutPage;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckoutStepdefs {

    @Managed
    HomePage homepage;

    @Managed
    CheckoutPage checkoutPage;

    @Given("I have a product in cart")
    public void iHaveProductInCart() {
        homepage.open();
        homepage.addFirstProductToCart();
        checkoutPage.open();
    }

    @When("I click the place order button")
    public void iClickThePlaceOrderButton() {
        checkoutPage.clickPlaceOrderBtn();
    }

    @And("I fill out every field {string}, {string}, {string}, {string}, {string}, {string}")
    public void iFillOutEveryField(String name, String country, String city, String card, String month, String year) {
        checkoutPage.enterName(name);
        checkoutPage.enterCountry(country);
        checkoutPage.enterCity(city);
        checkoutPage.enterCreditCard(card);
        checkoutPage.enterMonth(month);
        checkoutPage.enterYear(year);
    }

    @And("I click on Purchase")
    public void iClickOnPurchase() {
        checkoutPage.clickPurchaseBtn();
    }

    @Then("I should receive a pop up confirming my order")
    public void iShouldReceiveAPopUpConfirmingMyOrder() {
        assertThat("Thank you message should be displayed", checkoutPage.isThankYouMessageDisplayed(), is(true));
    }

        @Then("the message should include my details, the order ID, amount, and card number")
    public void the_message_should_include_my_details_the_order_id_amount_and_card_number() {
        String message = checkoutPage.thankYouOrderMessage();

        System.out.println("Purchase message: " + message);

        assertThat(message, containsString("Thank you for your purchase!"));
        assertThat (message, containsString("Id:"));
        assertThat(message, containsString("Amount:"));
        assertThat (message, containsString("Card Number:"));
    }

    @And("I leave {string} blank")
    public void iLeaveFieldBlank(String field) {
        switch(field) {
            case "Name":
                checkoutPage.enterName("");
                break;
            case "Credit Card":
                checkoutPage.enterCreditCard("");
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + field);
        }

    }
    @Then("the system should display an alert {string}")
    public void theSystemShouldDisplayAlert(String alertMessage) {
        String alertText = checkoutPage.getAlertText();
        assertThat(alertText, containsString("Please fill out Name and Creditcard."));
    }

    @Given("the cart is empty and checkout is opened")
    public void theCartIsEmptyAndCheckoutIsOpened() {
        homepage.open();
        checkoutPage.open();
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String name, String card) {
        checkoutPage.enterName(name);
        checkoutPage.enterCreditCard(card);
    }

    @And("the user clicks purchase")
    public void theUserClicks() {
        checkoutPage.clickPurchaseBtn();
    }

    @Then("a confirmation popup should appear")
    public void aConfirmationPopupShouldAppear() {
        assertThat("Thank you for your purchase!",
                checkoutPage.isThankYouMessageDisplayed(), is(true));
    }

    @And("the message should include order ID, amount, and card number")
    public void theMessageShouldIncludeOrderIDAmountAndCardNumber() {
        String message = checkoutPage.thankYouOrderMessage();
        System.out.println("DemoBlaze popup: " + message);


        assertThat(message, containsString("Thank you for your purchase!"));
        assertThat(message, containsString("Id:"));
        assertThat(message, containsString("Amount:"));
        assertThat(message, containsString("Card Number:"));
    }
}
