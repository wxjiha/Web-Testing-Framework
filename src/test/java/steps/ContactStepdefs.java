package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SignUpContactPage;

import java.util.List;
import java.util.Map;

public class ContactStepdefs {

    @Managed
    WebDriver driver;

    SignUpContactPage signUpContactPage;

    @Given("I am on the home page for contact form")
    public void iAmOnTheHomePageForContactForm() throws InterruptedException {
        signUpContactPage = new SignUpContactPage();
        signUpContactPage.setDriver(driver);
        signUpContactPage.open();

    }

    @And("I have clicked on the {string} link")
    public void iHaveClickedOnTheLink(String linkName) throws InterruptedException {
        signUpContactPage.openContactPage();
    }

    @And("I enter the following contact information")
    public void iEnterTheFollowingContactInformation(DataTable table) throws InterruptedException {
        List<Map<String, String>> contactList = table.asMaps(String.class, String.class);
        for (Map<String, String> row : contactList) {
            signUpContactPage.enterContactDetails(row.get("email"), row.get("name"), row.get("message"));
            signUpContactPage.clickSendMessage();
            String alertText = signUpContactPage.getAlertText();
            Assert.assertTrue(alertText.contains("Thanks"));
            signUpContactPage.acceptAlert();
            signUpContactPage.openContactPage();
        }
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Close")) {
            signUpContactPage.clickCloseButton();
        } else if (buttonName.equalsIgnoreCase("Send message")) {
            signUpContactPage.clickSendMessage();
        }
    }

    @Then("the Contact page should not be visible")
    public void theContactPageShouldNotBeVisible() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertFalse(signUpContactPage.isContactVisible());
    }

    @When("I leave all fields \\(email, name, message) empty")
    public void iLeaveAllFieldsEmailNameMessageEmpty() {
    }

    @Then("a popup saying {string} should appear")
    public void aPopupSayingShouldAppear(String expectedMessage) {
        String alertText = signUpContactPage.getAlertText();
        Assert.assertTrue(alertText.contains(expectedMessage));
        signUpContactPage.acceptAlert();
    }
}