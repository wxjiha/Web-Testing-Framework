package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    // NAVBAR ELEMENTS
    @FindBy(id = "login2")
    private WebElementFacade loginNavButton;

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

    // CATEGORY AND PRODUCT ELEMENTS
    @FindBy(className = "list-group")
    private WebElementFacade categoriesElement;

    @FindBy(css = ".hrefch")
    private List<WebElementFacade> productLinks;

    @FindBy(css = ".btn-success")
    private List<WebElementFacade> addToCartButtons;

    // ===== LOGIN METHODS =====
    public void openLoginModal() {
        loginNavButton.click();
    }

    public void enterUserName(String username) {
        userNameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return loggedInUserName.isDisplayed();
    }

    public String getLoggedInUserName() {
        return loggedInUserName.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isLoginButtonVisible() {
        return loginNavButton.isVisible();
    }

    // ===== CATEGORY AND PRODUCT METHODS =====
    private List<WebElement> getCategoriesElements() {
        return categoriesElement.findElements(By.id("itemc"));
    }

    public void clickMonitorsBtn() {
        List<WebElement> categories = getCategoriesElements();
        categories.get(2).click();
    }

    public List<WebElement> getItems() {
        WebElement items = find(By.id("tbodyid"));
        return items.findElements(By.className("card"));
    }

    public int itemsCount() {
        return getItems().size();
    }

    public void clickItem(String itemName) {
        for (WebElement card : getItems()) {
            WebElement name = card.findElement(By.className("hrefch"));
            if (name.getText().equals(itemName)) {
                name.click();
                break;
            }
        }
    }

    public void addFirstProductToCart() {
        productLinks.get(0).click();
        addToCartButtons.get(0).click();
    }
}