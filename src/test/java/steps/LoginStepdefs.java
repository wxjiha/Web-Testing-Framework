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
    public void iAmOnTheHomePageForLogging() {
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
}
