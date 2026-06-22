package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginMenu = By.id("login2");
    By usernameField = By.id("loginusername");
    By passwordField = By.id("loginpassword");
    By loginSubmitButton = By.xpath("//button[text()='Log in']");
    By welcomeText = By.id("nameofuser");

    By loginModal = By.id("logInModal");
    By signUpMenu = By.id("signin2");
    By logoutMenu = By.id("logout2");

    By closeButton =
            By.xpath("//div[@id='logInModal']//button[text()='Close']");

    public void clickLoginMenu() {
        wait.until(
                ExpectedConditions.elementToBeClickable(loginMenu)
        ).click();
    }

    public void inputUsername(String username) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginSubmitButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(loginSubmitButton)
        ).click();
    }

    public boolean isWelcomeTextDisplayed() {
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(welcomeText)
            );
            return driver.findElement(welcomeText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getWelcomeText() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(welcomeText)
        );
        return driver.findElement(welcomeText).getText();
    }

    public void verifyLoginValidationAlert() {
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertFalse(
                "Validation alert is empty",
                alertText.trim().isEmpty()
        );
        alert.accept();
    }

    public void verifyLoginPopupClosed() {
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(loginModal)
        );
    }

    public void login(String username, String password) {
        clickLoginMenu();
        inputUsername(username);
        inputPassword(password);
        clickLoginSubmitButton();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(welcomeText)
        );
    }

    public void verifyUserLoggedOut() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginMenu)
        );
        Assert.assertTrue(
                driver.findElement(loginMenu).isDisplayed()
        );
    }

    public boolean isLoginButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginMenu)
        ).isDisplayed();
    }

    public boolean isSignUpButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signUpMenu)
        ).isDisplayed();
    }

    public void clickCloseButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(closeButton)
        ).click();
    }

    public void clickLogoutButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(logoutMenu)
        ).click();
    }

    public boolean isLoginPopupDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginModal)
        ).isDisplayed();
    }
}
