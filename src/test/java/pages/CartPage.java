package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://demoblaze.com/cart.html")
public class CartPage extends PageObject {

    @FindBy(id = "tbodyid")
    private WebElementFacade cartTable;


    public List<WebElement> getCartItems(){
        return cartTable.findElements(By.className("success"));
    }

}
