package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@DefaultUrl("https://www.demoblaze.com/")
public class SignUpContactPage extends PageObject {

    @FindBy(id = "signin2")
    private WebElementFacade signupButton;

    @FindBy(id = "sign-username")
    private WebElementFacade usernameField;

    @FindBy(id = "sign-password")
    private WebElementFacade passwordField;

    @FindBy(css = "#signInModal .modal-footer button.btn.btn-primary")
    private WebElementFacade confirmSignupButton;

    @FindBy(linkText = "Contact")
    private WebElementFacade contactLink;

    @FindBy(id = "recipient-email")
    private WebElementFacade emailField;

    @FindBy(id = "recipient-name")
    private WebElementFacade nameField;

    @FindBy(id = "message-text")
    private WebElementFacade messageField;

    @FindBy(css = "#exampleModal .btn-primary")
    private WebElementFacade sendMessageButton;

    @FindBy(css = "#exampleModal .btn-secondary")
    private WebElementFacade closeButton;

    public void openSignupPage() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1000);
    }

    public boolean isSignupVisible() {
        return usernameField.isVisible() && passwordField.isVisible();
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickSignup() {
        confirmSignupButton.click();
        waitForAlert();
    }

    public void openContactPage() throws InterruptedException {
        contactLink.click();
        Thread.sleep(1000);
    }

    public void enterContactDetails(String email, String name, String message) {
        emailField.type(email);
        nameField.type(name);
        messageField.type(message);
    }

    public void clickSendMessage() {
        sendMessageButton.click();
        waitForAlert();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public boolean isContactVisible() {
        return emailField.isVisible();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}
