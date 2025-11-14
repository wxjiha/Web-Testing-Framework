package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.demoblaze.com/")
public class AboutusPage extends PageObject {

    @FindBy(linkText = "About us")
    private WebElementFacade aboutUsLink;

    @FindBy(id = "videoModal")
    private WebElementFacade aboutUsPopup;

    @FindBy(css = "#videoModal .modal-title")
    private WebElementFacade aboutUsPopupTitle;

    @FindBy(css = "#videoModal .btn-secondary")
    private WebElementFacade closeButton;

    public void openAboutUsPopup() {
        aboutUsLink.click();
        aboutUsPopup.waitUntilVisible();
    }

    public boolean isAboutUsPopupVisible() {
        return aboutUsPopup.isVisible();
    }

    public String getAboutUsPopupTitle() {
        return aboutUsPopupTitle.getText();
    }

    public boolean popupHasContent() {
        return aboutUsPopup.isVisible();
    }

    public void closeAboutUsPopup() {
        closeButton.click();
        waitForNoAboutUsPopup();
    }

    private void waitForNoAboutUsPopup() {
        aboutUsPopup.waitUntilNotVisible();
    }
}
