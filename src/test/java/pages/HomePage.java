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

@DefaultUrl("https://demoblaze.com/index.html")
public class HomePage extends PageObject {

    @FindBy(className = "list-group")
    private WebElementFacade categoriesElement;

    private List<WebElement> getCategoriesElements(){
        return categoriesElement.findElements(By.id("itemc"));
    }

    public void clickMonitorsBtn(){
        List<WebElement> categories = getCategoriesElements();
        categories.get(2).click();
    }

    public List<WebElement> getItems(){
        WebElement items = find(By.id("tbodyid"));
        return items.findElements(By.className("card"));
    }

    public int itemsCount(){
        return getItems().size();
    }

    public void clickItem(String itemName){
        for (WebElement card : getItems()){
            WebElement name = card.findElement(By.className("hrefch"));
            if (name.getText().equals(itemName)){
                name.click();
                break;
            }
        }
    }



    @FindBy(css = ".hrefch")
    private List<WebElementFacade> productLinks;

    @FindBy(css = ".btn-success")
    private List<WebElementFacade> addToCartButtons;

    public void addFirstProductToCart() {
        productLinks.get(0).click();
        addToCartButtons.get(0).click();
    }
}
