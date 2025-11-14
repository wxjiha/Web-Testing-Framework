package steps;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CheckoutPage;
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
    CheckoutPage checkoutPage;


    @Before(value = "not @AccumulateCart")
    public void clearCartBeforeScenario(){
        homePage.getDriver().manage().deleteAllCookies();
        homePage.getDriver().get("https://demoblaze.com");
        ((JavascriptExecutor) homePage.getDriver()).executeScript("localStorage.clear(); sessionStorage.clear();");

    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.open();
    }

    @When("I click on the Monitors category")
    public void iClickOnTheMonitorsCategory() throws InterruptedException {
        homePage.clickMonitorsBtn();
    }

    @Then("I should see only the two monitors")
    public void iShouldSeeOnlyTheTwoMonitors() {
        homePage.waitFor(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#tbodyid .card"), 2));
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
        checkoutPage.waitFor(ExpectedConditions.numberOfElementsToBe(By.className("success"), productCountInt));
        assertThat(checkoutPage.getCartItems().size(), is(productCountInt));
    }

    @When("I click on the delete button")
    public void iClickOnTheDeleteButton() {
        checkoutPage.clickFirstDeleteButton();
    }

    @Then("My cart should be empty")
    public void myCartShouldBeEmpty() {
        checkoutPage.waitForCartToBeEmpty();
        var x  = checkoutPage.getCartItems();
        assertThat(x.size(),is(0));
    }

    @And("My Cart total should be {string}")
    public void myCartTotalShouldBe(String cumulativeTotal) {
        assertThat(checkoutPage.getTotalPrice(),is(cumulativeTotal));
    }

    @And("I Add the item to cart twice")
    public void iAddTheItemToCartTwice() {
        for (int i = 0; i < 2 ; i++) {
            productPage.clickAddToCart();
            Alert alert = productPage.waitForAlert();
            alert.accept();
        }
    }

}
