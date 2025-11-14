package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class LoginStepdefs {

    @Managed
    WebDriver driver;
    HomePage homePage;

    @Given("I am on the home page for logging in")
    public void iAmOnTheHomePageForLoggingIn() {
        homePage.open();
    }

    @And("have clicked on the login button")
    public void haveClickedOnTheLoginButton() {
        homePage.openLoginModal();
    }

    @And("I entered the username {string}")
    public void iEnteredTheUsername(String username) {
        homePage.enterUserName(username);
    }

    @And("I entered the password  {string}")
    public void iEnteredThePassword(String password) {
        homePage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        homePage.clickLoginButton();
    }

    @Then("I should return to the home page")
    public void iShouldReturnToTheHomePage() {
        homePage.waitFor(2000);
        String currentUrl = homePage.getDriver().getCurrentUrl();
        assert currentUrl.contains("demoblaze.com") : "Not on home page!";
    }

    @And("my username should be visible on the navbar")
    public void myUsernameShouldBeVisibleOnTheNavbar() {
        homePage.waitForCondition().until(driver -> homePage.isUserLoggedIn());
        assert homePage.isUserLoggedIn() : "Username not visible on navbar!";
        System.out.println("Logged in as: " + homePage.getLoggedInUserName());
    }

    @Then("I should see a pop up saying user does not exist")
    public void iShouldSeeAPopUpSayingUserDoesNotExist() {
        Alert alert = homePage.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert says: " + alertText);
        alert.accept();
        Assertions.assertThat(alertText.contains("User does not exist"));
    }

    @Then("I should see a pop up saying wrong password")
    public void iShouldSeeAPopUpSayingWrongPassword() {
        Alert alert = homePage.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert says: " + alertText);
        alert.accept();
        Assertions.assertThat(alertText.contains("Wrong password"));
    }

    @And("I leave the username field blank")
    public void iLeaveTheUsernameFieldBlank() {
        homePage.enterUserName("");
    }

    @Then("I should see a pop up telling me to fill out Username and password")
    public void iShouldSeeAPopUpTellingMeToFillOutUsernameAndPassword() {
        Alert alert = homePage.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert says: " + alertText);
        alert.accept();

        Assertions.assertThat(alertText)
                .as("Expected alert text to ask for username/password")
                .containsIgnoringCase("fill out Username and Password");
    }

    @And("I leave the password field blank")
    public void iLeaveThePasswordFieldBlank() {
        homePage.enterPassword("");
    }

    @Given("I am logged in already")
    public void iAmLoggedInAlready() {
        homePage.open();
        homePage.openLoginModal();
        homePage.enterUserName("goodtest");
        homePage.enterPassword("password");
        homePage.clickLoginButton();

        homePage.waitForCondition().until(driver -> homePage.isUserLoggedIn());
        Assertions.assertThat(homePage.isUserLoggedIn())
                .as("User should be logged in before proceeding")
                .isTrue();
    }

    @When("I click the log out button")
    public void iClickTheLogOutButton() {
        homePage.clickLogoutButton();
    }

    @And("my username should no longer be on the navbar")
    public void myUsernameShouldNoLongerBeOnTheNavbar() {
        boolean userVisible;
        try {
            userVisible = homePage.isUserLoggedIn();
        } catch (Exception e) {
            userVisible = false;
        }

        Assertions.assertThat(userVisible)
                .as("Username should not be visible after logout")
                .isFalse();
    }

    @And("there should be a Log In Button on the navbar")
    public void thereShouldBeALogInButtonOnTheNavbar() {
        Assertions.assertThat(homePage.isLoginButtonVisible())
                .as("Login button should be visible after logout")
                .isTrue();
    }
}
