package steps;

import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CheckoutStepdefs {

    HomePage homepage;
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
        assert checkoutPage.isThankYouMessageDisplayed();
    }

    @Then("the message should include my details, the order ID, amount, and card number")
    public void the_message_should_include_my_details_the_order_id_amount_and_card_number() {
        String message = checkoutPage.thankYouOrderMessage();

        System.out.println("Purchase message: " + message);

        assert message.contains("Thank you");
        assert message.contains("Id");
        assert message.contains("Amount");
        assert message.contains("Card");
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
        assertThat(alertText, containsString(alertMessage));
    }

}
