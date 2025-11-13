package pages;

//package pages;

//package com.nam.sparta.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://www.demoblaze.com/")
public class SignUpPage extends PageObject {


    @FindBy(id = "signin2")
    private WebElementFacade signupButton;


    @FindBy(id = "sign-username")
    private WebElementFacade usernameField;


    @FindBy(id = "sign-password")
    private WebElementFacade passwordField;

    // Better locator for the Sign Up button inside the modal
    // This targets the footer of the active signup modal specifically
    @FindBy(css = "#signInModal .modal-footer button.btn.btn-primary")
    private WebElementFacade confirmSignupButton;




    public void openSignupModal() throws InterruptedException {
        signupButton.click();
        Thread.sleep(1000);


    }
    public boolean isSignupModalVisible() {
        return usernameField.isVisible() && passwordField.isVisible();
    }

    /** Enters username into the signup form */
    public void enterUsername(String username) {
        usernameField.type(username);
    }

    /** Enters password into the signup form */
    public void enterPassword(String password) {
        passwordField.type(password);
    }


    public void clickSignup() {
        confirmSignupButton.click();
        waitForAlert();  // wait for alert after clicking
    }

    /** Waits explicitly for the alert to appear */
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

