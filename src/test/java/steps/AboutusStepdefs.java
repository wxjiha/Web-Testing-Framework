package steps;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import pages.AboutusPage;
import pages.HomePage;

public class AboutusStepdefs {

    @Managed
    HomePage homePage;

    @Managed
    AboutusPage aboutusPage;

    @Given("I am on the DemoBlaze homepage")
    public void i_am_on_homepage() {
        homePage.open();
    }

    @When("I click on the About us link")
    public void i_click_about_us() {
        aboutusPage.openAboutUsPopup();
    }

    @Then("the About Us popup should appear")
    public void the_about_us_popup_should_appear() {
        Assertions.assertThat(aboutusPage.isAboutUsPopupVisible()).isTrue();
    }

    @Then("the popup should display a title {string}")
    public void popup_should_display_title(String expectedTitle) {
        Assertions.assertThat(aboutusPage.getAboutUsPopupTitle()).isEqualTo(expectedTitle);
    }

    @Then("the popup should contain a video or description text")
    public void popup_should_contain_video_or_text() {
        Assertions.assertThat(aboutusPage.popupHasContent()).isTrue();
    }

    @Then("I should be able to close the popup")
    public void i_can_close_popup() {
        aboutusPage.closeAboutUsPopup();
        Assertions.assertThat(aboutusPage.isAboutUsPopupVisible()).isFalse();
    }
}
