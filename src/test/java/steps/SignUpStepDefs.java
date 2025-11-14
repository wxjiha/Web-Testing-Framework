package steps;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import pages.SignUpContactPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SignUpStepDefs {

    @Managed
    WebDriver driver;

    SignUpContactPage signUpContactPage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        signUpContactPage = new SignUpContactPage();
        signUpContactPage.setDriver(driver);
        signUpContactPage.open();
    }

    @And("I have clicked on the signup button")
    public void iHaveClickedOnTheSignupButton() throws InterruptedException {
        signUpContactPage.openSignupPage();
        assertThat("Signup page should be visible", signUpContactPage.isSignupVisible());
    }



    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        signUpContactPage.enterUsername(username);
    }
    @When("I enter a new username {string}")
    public void iEnterANewUsername(String newuser) {
        String uniqueUser = newuser + "_" + java.util.UUID.randomUUID();
        signUpContactPage.enterUsername(uniqueUser);

    }

    @And("I enter a password {string}")
    public void iEnterAPassword(String password) {
        signUpContactPage.enterPassword(password);
    }

    @And("I click the signup confirmation button")
    public void iClickTheSignupConfirmationButton() {
        signUpContactPage.clickSignup();
    }

    @Then("I should see a popup message saying {string}")
    public void iShouldSeeAPopupMessageSaying(String expectedMessage) {
        String actualAlertText = signUpContactPage.getAlertText();
        assertThat(actualAlertText, containsString(expectedMessage));
        signUpContactPage.acceptAlert();
    }

    @Then("I should see an alert message saying {string}")
    public void iShouldSeeAnAlertMessageSaying(String expectedMessage) {
        String actualAlertText = signUpContactPage.getAlertText();
        assertThat(actualAlertText, containsString(expectedMessage));
        signUpContactPage.acceptAlert();
    }


}
