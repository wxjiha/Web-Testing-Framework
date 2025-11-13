package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://demoblaze.com/prod.html")
public class ProductPage extends PageObject {

    @FindBy(className = "name")
    private WebElementFacade productName;

    public String getProductName() {
        return productName.getText();
    }
}
