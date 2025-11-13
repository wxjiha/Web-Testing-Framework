package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://demoblaze.com/prod.html")
public class ProductPage extends PageObject {

    private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

    @FindBy(className = "name")
    private WebElementFacade productName;

    @FindBy(className = "btn-lg")
    private WebElementFacade addToCartBtn;

    @FindBy(id = "cartur")
    private WebElementFacade goToCartBtn;

    public String getProductName() {
        return productName.getText();
    }

    public void clickAddToCart(){
        addToCartBtn.click();
    }

    public void clickGoToCart(){
        goToCartBtn.waitUntilClickable();
        goToCartBtn.click();
    }

    public Alert waitForAlert(){
        return wait.until(d -> getAlert());
    }



}
