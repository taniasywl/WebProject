package stepdef;

import io.cucumber.java.en.*;
import page.AboutusPage;



public class AboutusSteps {
    AboutusPage aboutusPage = new AboutusPage(BaseTest.driver);

    @Given("the About Us popup is displayed")
    public void the_about_us_popup_is_displayed() {
        aboutusPage.openAboutUs();
        aboutusPage.verifyPopupDisplayed();
    }

    @Given("the video is playing")
    public void video_is_playing() {
        aboutusPage.openAboutUs();
        aboutusPage.clickPlay();
    }

    @Given("the user has closed the About Us popup")
    public void user_closed_popup() {
        aboutusPage.openAboutUs();
        aboutusPage.clickClose();
        aboutusPage.verifyPopupClosed();
    }

    @When("the user clicks the About Us menu")
    public void the_user_clicks_the_about_us_menu() {
        aboutusPage.openAboutUs();
    }

    @When("the user clicks About Us button {string}")
    public void the_user_clicks_about_us_button(String button) {
        switch (button.toLowerCase()) {
            case "play":
                aboutusPage.clickPlay();
                break;

            case "pause":
                aboutusPage.clickPause();
                break;

            case "close":
                aboutusPage.clickClose();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported button: " + button
                );
        }
    }

    @When("the user clicks the About Us X icon")
    public void the_user_clicks_the_about_us_x_icon() {
        aboutusPage.clickX();
    }

    @Then("the About Us popup should be displayed again")
    public void popup_should_be_displayed_again() {
        aboutusPage.verifyPopupDisplayedAgain();
    }

    @Then("the About Us popup should be closed")
    public void popup_should_be_closed() {
        aboutusPage.verifyPopupClosed();
    }

    @Then("the video should be displayed")
    public void video_should_be_displayed() {
        aboutusPage.verifyVideoDisplayed();
    }

    @Then("the Play button should be displayed")
    public void play_button_should_be_displayed() {
        aboutusPage.verifyPlayButtonDisplayed();
    }

    @Then("the video controls should be available")
    public void video_controls_should_be_available() {
        aboutusPage.verifyControlsAvailable();
    }

    @Then("the video should start playing")
    public void video_should_start_playing() {
        aboutusPage.verifyVideoPlaying();
    }

    @Then("the video should be paused")
    public void video_should_be_paused() {
        aboutusPage.verifyVideoPaused();
    }

    @Then("the About Us Close button should be displayed")
    public void about_us_close_button_should_be_displayed() {
        aboutusPage.verifyCloseButtonDisplayed();
    }
}
