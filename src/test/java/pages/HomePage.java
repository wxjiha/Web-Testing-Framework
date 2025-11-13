package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://demoblaze.com/")
public class HomePage extends PageObject{

    // NAVBAR ELEMENTS
    @FindBy(id = "login2")
    private WebElementFacade loginNavButton;   // Opens login modal

    @FindBy(id = "logout2")
    private WebElementFacade logoutButton;

    @FindBy(id = "nameofuser")
    private WebElementFacade loggedInUserName;

    // LOGIN MODAL ELEMENTS
    @FindBy(id = "loginusername")
    private WebElementFacade userNameField;

    @FindBy(id = "loginpassword")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElementFacade loginButton;

    // ===== METHODS =====

    public void openLoginModal() {
        loginNavButton.click();  // Click login button on navbar
    }

    public void enterUserName(String username) {
        userNameField.type(username);  // Type username in modal
    }

    public void enterPassword(String password) {
        passwordField.type(password);  // Type password in modal
    }

    public void clickLoginButton() {
        loginButton.click();  // Click login in modal
    }

    public boolean isUserLoggedIn() {
        return loggedInUserName.isDisplayed();  // Check if username is visible
    }

    public String getLoggedInUserName() {
        return loggedInUserName.getText();  // Get text of logged in user
    }

    public void clickLogoutButton() {
        logoutButton.click();  // Click logout
    }
}
