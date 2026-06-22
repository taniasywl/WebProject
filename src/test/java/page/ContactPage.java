package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {
    WebDriver driver;
    WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By contactMenu = By.xpath("//a[text()='Contact']");

    By contactModal = By.id("exampleModal");

    By emailField = By.id("recipient-email");
    By nameField = By.id("recipient-name");
    By messageField = By.id("message-text");

    By sendButton = By.xpath("//button[text()='Send message']");
    By closeButton = By.xpath("(//button[text()='Close'])[1]");
    By xButton = By.xpath("//div[@id='exampleModal']//button[@class='close']");

    // ================= ACTIONS =================

    public void openContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactModal));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys(email);
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField))
                .sendKeys(name);
    }

    public void enterMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageField))
                .sendKeys(message);
    }

    public void clickSend() {
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public void clickX() {
        wait.until(ExpectedConditions.elementToBeClickable(xButton)).click();
    }

    public boolean isContactPopupDisplayed() {
        try {
            WebElement popup = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(contactModal)
            );
            return popup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isContactPopupClosed() {
        try {
            return wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(contactModal)
            );
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        ).isDisplayed();
    }

    public boolean isNameDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        ).isDisplayed();
    }

    public boolean isMessageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(messageField)
        ).isDisplayed();
    }

    public boolean isSendButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(sendButton)
        ).isDisplayed();
    }

    public boolean isCloseButtonDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(closeButton)
        ).isDisplayed();
    }
}
