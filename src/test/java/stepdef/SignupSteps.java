package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.SignupPage;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static stepdef.BaseTest.driver;

public class SignupSteps {
    SignupPage signupPage = new SignupPage(driver);

    @When("the user clicks the Sign Up button")
    public void userClicksSignUpButton() {
        signupPage.clickSignUpMenu();
    }

    @And("the user enters a username {string}")
    public void userEntersUsername(String username) {
        signupPage.inputUsername(username);
    }

    @And("the user enters a unique username")
    public void userEntersUniqueUsername() {
        String username = "user" + System.currentTimeMillis();
        signupPage.inputUsername(username);
    }

    @And("the user enters a password {string}")
    public void userEntersPassword(String password) {
        signupPage.inputPassword(password);
    }

    @And("clicks the Sign Up submit button")
    public void clicksSignUpSubmitButton() {
        signupPage.clickSignupButton();
    }

    @Then("the user should see a successful signup alert")
    public void userShouldSeeSuccessfulSignupAlert() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(
                "Unexpected success alert message",
                "Sign up successful.",
                alert.getText()
        );
    }

    @Then("the user should see an existing user alert")
    public void userShouldSeeExistingUserAlert() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(
                "Unexpected existing user alert message",
                "This user already exist.",
                alert.getText()
        );
    }

    @And("the Sign Up popup should be closed")
    public void signUpPopupShouldBeClosed() {
        Assert.assertTrue(
                "Sign Up popup is still displayed",
                signupPage.isSignupPopupClosed()
        );
    }

    @When("the user clicks the Close button")
    public void theUserClicksTheCloseButton() {
        signupPage.clickCloseButton();
    }

    @Then("the user should see a signup validation alert")
    public void theUserShouldSeeASignupValidationAlert() {
        String actualAlert = signupPage.getAlertText();
        Assert.assertNotNull(actualAlert);
        Assert.assertFalse(actualAlert.isEmpty());
    }
    @When("the user clicks the Sign Up X icon")
    public void theUserClicksTheSignUpXIcon() {
        signupPage.clickXButton();
    }
}
