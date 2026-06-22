package page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By signUpMenu = By.id("signin2");

    By usernameField = By.id("sign-username");

    By passwordField = By.id("sign-password");

    By signUpButton =
            By.xpath("//div[@id='signInModal']//button[text()='Sign up']");

    By signUpModal = By.id("signInModal");
    By closeButton =
            By.xpath("//div[@id='signInModal']//button[text()='Close']");
    By xButton = By.xpath("//*[@id='signInModal']/div/div/div[1]/button");

    public void clickSignUpMenu() {
        wait.until(
                ExpectedConditions.elementToBeClickable(signUpMenu)
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

    public void clickSignupButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(signUpButton)
        ).click();
    }

    public boolean isSignupPopupDisplayed() {
        try {
            return driver.findElement(signUpModal).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }
    public String getAlertText() {
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public boolean isSignupPopupClosed() {
        try {
            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(signUpModal)
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickXButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(xButton)
        ).click();
    }

}

