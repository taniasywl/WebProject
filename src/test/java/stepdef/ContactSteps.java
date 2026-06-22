package stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import page.ContactPage;

import static stepdef.BaseTest.driver;

public class ContactSteps {
    ContactPage contactPage = new ContactPage(driver);

    @Given("the user is on the homepage")
    public void user_on_homepage() {
        driver.get("https://www.demoblaze.com/index.html");
        Assert.assertTrue(
                "Homepage is not loaded",
                driver.getTitle().contains("STORE")
        );
    }

    @Then("the Contact popup should be displayed")
    public void contact_popup_displayed() {
        Assert.assertTrue(
                "Contact popup is not displayed",
                contactPage.isContactPopupDisplayed()
        );
    }

    @Then("the Contact Email field should be displayed")
    public void email_displayed() {
        Assert.assertTrue(
                "Email field is not displayed",
                contactPage.isEmailDisplayed()
        );
    }

    @Then("the Contact Name field should be displayed")
    public void name_displayed() {
        Assert.assertTrue(
                "Name field is not displayed",
                contactPage.isNameDisplayed()
        );
    }

    @Then("the Message field should be displayed")
    public void message_displayed() {
        Assert.assertTrue(
                "Message field is not displayed",
                contactPage.isMessageDisplayed()
        );
    }

    @Then("the Send Message button should be displayed")
    public void send_button_displayed() {
        Assert.assertTrue(
                "Send Message button is not displayed",
                contactPage.isSendButtonDisplayed()
        );
    }

    @Then("the Close button should be displayed")
    public void close_button_displayed() {
        Assert.assertTrue(
                "Close button is not displayed",
                contactPage.isCloseButtonDisplayed()
        );
    }

    @Given("the Contact popup is displayed")
    public void contact_popup_is_displayed() {
        contactPage.openContact();
        Assert.assertTrue(
                "Contact popup is not displayed",
                contactPage.isContactPopupDisplayed()
        );
    }

    @When("the user enters {string} into the Contact Email field")
    public void enter_email(String email) {
        contactPage.enterEmail(email);
    }

    @When("the user enters {string} into the Contact Name field")
    public void enter_name(String name) {
        contactPage.enterName(name);
    }

    @When("the user enters {string} into the Message field")
    public void enter_message(String message) {
        contactPage.enterMessage(message);
    }

    @When("the user clicks button {string}")
    public void click_button(String button) {
        if (button.equalsIgnoreCase("Send Message")) {
            contactPage.clickSend();

        } else if (button.equalsIgnoreCase("Close")) {
            contactPage.clickClose();
        }
    }

    @Then("a success alert should be displayed")
    public void success_alert() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(
                "Alert message is incorrect",
                alertText.contains("Thanks")
        );
        driver.switchTo().alert().accept();
    }

    @When("the user clicks the X icon")
    public void click_x_icon() {
        contactPage.clickX();
    }

    @Then("the Contact popup should be closed")
    public void popup_closed() {
        Assert.assertTrue(
                "Popup is still displayed",
                contactPage.isContactPopupClosed()
        );
    }
}
