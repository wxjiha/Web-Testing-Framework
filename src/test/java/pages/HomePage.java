package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://demoblaze.com/index.html")
public class HomePage extends PageObject {

    @FindBy(css = ".hrefch")
    private List<WebElementFacade> productLinks;

    @FindBy(css = ".btn-success")
    private List<WebElementFacade> addToCartButtons;

    public void addFirstProductToCart() {
        productLinks.get(0).click();
        addToCartButtons.get(0).click();
    }
}
