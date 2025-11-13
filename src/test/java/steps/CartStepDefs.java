package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Alert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CartStepDefs {

    @Managed
    HomePage homePage;

    @Managed
    ProductPage productPage;

    @Managed
    CartPage cartPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.open();
    }

    @When("I click on the Monitors category")
    public void iClickOnTheMonitorsCategory() {
        homePage.clickMonitorsBtn();
    }

    @Then("I should see only the two monitors")
    public void iShouldSeeOnlyTheTwoMonitors() {
        assertThat(homePage.itemsCount(), is(2));
    }

    @When("I click on the {string}")
    public void iClickOnThe(String productName) {
        homePage.clickItem(productName);
    }

    @Then("I should land on the product detail page for {string}")
    public void iShouldLandOnTheProductDetailPageFor(String productName) {
        assertThat(homePage.getDriver().getCurrentUrl(), containsString("/prod.html"));
        assertThat(productPage.getProductName(), is(productName));
    }

    @When("I am on the product detail page")
    public void iAmOnTheProductDetailPage() {
    }

    @And("I click Add to Cart")
    public void iClickAddToCart() {
        productPage.clickAddToCart();
    }

    @Then("I should see a confirmation alert")
    public void iShouldSeeAConfirmationAlert() {
        Alert alert = productPage.waitForAlert();
        assertThat(alert.getText(), is("Product added"));
        alert.accept();
    }

    @And("On the cart page, I should have {string} items in my cart")
    public void onTheCartPageIsOneOfInMyCart(String productCount) {

        int productCountInt = Integer.parseInt(productCount);

        productPage.clickGoToCart();
        assertThat(cartPage.getCartItems().size(), is(productCountInt));
    }
}
