package steps;

import net.thucydides.core.annotations.Managed;
import pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SignUpStepDefs {

    @Managed
    SignUpPage signupPage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        signupPage.open();
    }

    @And("I have clicked on the signup button")
    public void iHaveClickedOnTheSignupButton() throws InterruptedException {
        signupPage.openSignupModal();
        assertThat("Signup modal should be visible", signupPage.isSignupModalVisible());
    }

    @When("I enter a new username {string}")
    public void iEnterANewUsername(String username) {
        signupPage.enterUsername(username);
    }

    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        signupPage.enterUsername(username);
    }

    @And("I enter a password {string}")
    public void iEnterAPassword(String password) {
        signupPage.enterPassword(password);
    }

    @And("I click the signup confirmation button")
    public void iClickTheSignupConfirmationButton() {
        signupPage.clickSignup();
    }

    @Then("I should see a popup message saying {string}")
    public void iShouldSeeAPopupMessageSaying(String expectedMessage) {
        String actualAlertText = signupPage.getAlertText();
        assertThat(actualAlertText, containsString(expectedMessage));
        signupPage.acceptAlert();
    }

    @Then("I should see an alert message saying {string}")
    public void iShouldSeeAnAlertMessageSaying(String expectedMessage) {
        String actualAlertText = signupPage.getAlertText();
        assertThat(actualAlertText, containsString(expectedMessage));
        signupPage.acceptAlert();
    }


}