package stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import static stepdef.BaseTest.driver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the demoblaze homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.demoblaze.com/index.html");
        Assert.assertTrue(
                "Homepage is not displayed",
                driver.getCurrentUrl().contains("demoblaze")
        );
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String button) {
        switch (button) {
            case "Login":
                loginPage.clickLoginMenu();
                break;

            case "Login Submit":
                loginPage.clickLoginSubmitButton();
                break;

            case "Close":
                loginPage.clickCloseButton();
                break;

            case "Logout":
                loginPage.clickLogoutButton();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown button : " + button
                );
        }
    }

    @And("the user enters login username {string}")
    public void userEntersLoginUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("the user enters login password {string}")
    public void userEntersLoginPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Then("the user should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() {
        Assert.assertTrue(
                "Welcome text is not displayed",
                loginPage.isWelcomeTextDisplayed()
        );
    }

    @And("the user should see {string} on the navigation bar")
    public void userShouldSeeWelcomeText(String expectedText) {
        Assert.assertEquals(
                "Incorrect welcome text",
                expectedText,
                loginPage.getWelcomeText()
        );
    }

    @Then("the user should see an invalid login alert")
    public void userShouldSeeInvalidLoginAlert() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertFalse(
                "Alert message is empty",
                alertText.trim().isEmpty()
        );
    }

    @And("the user clicks {string} on the alert")
    public void theUserClicksOnTheAlert(String action) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        if (action.equalsIgnoreCase("OK")) {
            alert.accept();
        }
    }

    @And("the user should remain on the homepage")
    public void userShouldRemainOnHomepage() {
        Assert.assertTrue(
                "User is not on homepage",
                driver.getCurrentUrl().contains("demoblaze")
        );
    }

    @Then("the user should see a login validation alert")
    public void theUserShouldSeeALoginValidationAlert() {
        loginPage.verifyLoginValidationAlert();
    }

    @Then("the Login popup should be closed")
    public void theLoginPopupShouldBeClosed() {
        loginPage.verifyLoginPopupClosed();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.login("taniasywl", "tania123");
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        loginPage.verifyUserLoggedOut();
    }

    @Then("the {string} button should be displayed")
    public void theButtonShouldBeDisplayed(String button) {
        switch (button) {
            case "Log in":
                assertTrue(loginPage.isLoginButtonDisplayed());
                break;

            case "Sign up":
                assertTrue(loginPage.isSignUpButtonDisplayed());
                break;

            default:
                throw new RuntimeException("Button not found: " + button);
        }
    }
}