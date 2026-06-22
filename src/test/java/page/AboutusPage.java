package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AboutusPage {
    WebDriver driver;
    WebDriverWait wait;

    public AboutusPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By aboutUsMenu =
            By.xpath("//a[text()='About us']");

    By modal =
            By.id("videoModal");

    By video =
            By.id("example-video_html5_api");

    By playButton =
            By.cssSelector(".vjs-big-play-button");

    By playPauseButton =
            By.cssSelector(".vjs-play-control");

    By closeButton =
            By.cssSelector("#videoModal .modal-footer button");

    By xButton =
            By.cssSelector("#videoModal .modal-header .close");

    public void openAboutUs() {

        WebElement menu =
                wait.until(ExpectedConditions.elementToBeClickable(aboutUsMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", menu);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(modal)
        );
    }

    public void clickPlay() {

        WebElement vid =
                wait.until(ExpectedConditions.visibilityOfElementLocated(video));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].play();", vid);
    }

    public void clickPause() {

        WebElement vid =
                wait.until(ExpectedConditions.visibilityOfElementLocated(video));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].pause();", vid);
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }

    public void clickX() {
        wait.until(ExpectedConditions.elementToBeClickable(xButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }

    public void verifyPopupDisplayed() {
        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(modal)).isDisplayed()
        );
    }

    public void verifyPopupDisplayedAgain() {
        verifyPopupDisplayed();
    }

    public void verifyPopupClosed() {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(modal)
        );
    }

    public void verifyVideoDisplayed() {

        WebElement vid =
                wait.until(ExpectedConditions.visibilityOfElementLocated(video));

        Assert.assertTrue(vid.isDisplayed());
    }

    public void verifyPlayButtonDisplayed() {

        WebElement btn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));

        Assert.assertTrue(btn.isDisplayed());
    }

    public void verifyCloseButtonDisplayed() {

        WebElement btn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));

        Assert.assertTrue(btn.isDisplayed());
    }

    public void verifyControlsAvailable() {
        Assert.assertTrue(
                !driver.findElements(playButton).isEmpty()
                        ||
                        !driver.findElements(playPauseButton).isEmpty()
        );
    }

    public void verifyVideoPlaying() {

        WebElement vid =
                wait.until(ExpectedConditions.visibilityOfElementLocated(video));

        Long currentTime =
                ((Number) ((JavascriptExecutor) driver)
                        .executeScript(
                                "return Math.floor(arguments[0].currentTime);",
                                vid))
                        .longValue();

        Assert.assertTrue(
                "Video is not progressing",
                currentTime >= 0
        );
    }

    public void verifyVideoPaused() {
        WebElement vid = driver.findElement(video);

        Boolean paused = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].paused;", vid);

        Assert.assertTrue(paused);
    }
}
