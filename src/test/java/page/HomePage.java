package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By logo = By.id("nava");
    By categorySection = By.id("cat");
    By productCards = By.cssSelector(".card");
    By nextBannerButton = By.cssSelector(".carousel-control-next");

    By cartMenu = By.id("cartur");
    By loginMenu = By.id("login2");
    By signupMenu = By.id("signin2");
    By contactMenu = By.xpath("//a[text()='Contact']");

    By loginModal = By.id("logInModal");
    By signupModal = By.id("signInModal");
    By aboutUsModal = By.id("videoModal");

    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");

    By signupUsername = By.id("sign-username");
    By signupPassword = By.id("sign-password");

    By productNameDetail = By.cssSelector(".name");
    By productPriceDetail = By.cssSelector(".price-container");
    By addToCartButton = By.xpath("//a[text()='Add to cart']");

    By nextButton = By.id("next2");
    By prevButton = By.id("prev2");
    By products = By.cssSelector(".card-title a");

    public void openHomepage() {
        driver.get("https://www.demoblaze.com/");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(logo)
        );
    }

    public void clickCategory(String category) {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='" + category + "']")
                )
        ).click();
    }


    public void clickProduct(String productName) {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='" + productName + "']")
                )
        ).click();
    }


    public void clickMenu(String menu) {
        switch (menu) {
            case "Contact":
                wait.until(
                        ExpectedConditions.elementToBeClickable(contactMenu)
                ).click();
                break;
            case "Cart":
                wait.until(
                        ExpectedConditions.elementToBeClickable(cartMenu)
                ).click();
                break;
            case "Log in":
                wait.until(
                        ExpectedConditions.elementToBeClickable(loginMenu)
                ).click();
                break;
            case "Sign up":
                wait.until(
                        ExpectedConditions.elementToBeClickable(signupMenu)
                ).click();
                break;
            case "About us":
                driver.findElement(
                        By.xpath("//a[text()='About us']")
                ).click();
                break;
        }
    }


    public void clickNextBanner() {
        driver.findElement(nextBannerButton).click();
    }

    public void clickButton(String buttonName) {
        By buttonLocator =
                By.xpath("//button[text()='" + buttonName + "'] | //a[contains(text(),'" + buttonName + "')]");
        wait.until(
                ExpectedConditions.elementToBeClickable(buttonLocator)
        ).click();
    }

    public void verifyLogoDisplayed() {
        Assert.assertTrue(
                "Product Store logo should be displayed",
                driver.findElement(logo).isDisplayed()
        );
    }

    public void verifyNavigationMenuDisplayed() {
        Assert.assertTrue(
                "Cart menu should be displayed",
                driver.findElement(cartMenu).isDisplayed()
        );
        Assert.assertTrue(
                "Login menu should be displayed",
                driver.findElement(loginMenu).isDisplayed()
        );
        Assert.assertTrue(
                "Signup menu should be displayed",
                driver.findElement(signupMenu).isDisplayed()
        );
    }

    public void verifyCategorySectionDisplayed() {
        Assert.assertTrue(
                "Category section should be displayed",
                driver.findElement(categorySection).isDisplayed()
        );
    }


    public void verifyProductListDisplayed() {
        Assert.assertFalse(
                "Product list should not be empty",
                driver.findElements(productCards).isEmpty()
        );
    }


    public void verifyCategoryDisplayed(String category) {
        Assert.assertTrue(
                "Category not found : " + category,
                driver.findElement(
                        By.xpath("//a[text()='" + category + "']")
                ).isDisplayed()
        );
    }


    public void verifyProductCardsDisplayed() {
        Assert.assertTrue(
                "Product cards should be displayed",
                driver.findElements(productCards).size() > 0
        );
    }


    public void verifyProductInformationDisplayed() {
        List<WebElement> cards =
                driver.findElements(productCards);
        Assert.assertFalse(
                "Product list is empty",
                cards.isEmpty()
        );
    }

    public void verifyProductsDisplayed() {
        Assert.assertTrue(
                "Products should be displayed",
                driver.findElements(productCards).size() > 0
        );
    }


    public void verifyProductDisplayed(String productName) {
        Assert.assertTrue(
                "Product not found : " + productName,
                driver.findElement(
                        By.xpath("//a[text()='" + productName + "']")
                ).isDisplayed()
        );
    }


    public void verifyProductCount(int expectedCount) {
        wait.until(
                d -> d.findElements(productCards).size() > 0
        );
        int actualCount =
                driver.findElements(productCards).size();
        Assert.assertEquals(
                "Product count mismatch",
                expectedCount,
                actualCount
        );
    }


    public void verifyBannerChanged() {
        Assert.assertTrue(
                "Banner button should be displayed",
                driver.findElement(nextBannerButton).isDisplayed()
        );
    }


    public void verifyProductDetailPageDisplayed() {
        Assert.assertTrue(
                "Product detail page should be displayed",
                driver.findElement(productNameDetail).isDisplayed()
        );
    }


    public void verifyProductName(String expectedName) {
        Assert.assertEquals(
                "Product name mismatch",
                expectedName,
                driver.findElement(productNameDetail).getText()
        );
    }

    public void verifyProductPrice() {
        Assert.assertFalse(
                "Product price should not be empty",
                driver.findElement(productPriceDetail)
                        .getText()
                        .isEmpty()
        );
    }


    public void verifyProductDescription() {
        Assert.assertTrue(
                "Product description should be displayed",
                driver.findElement(
                        By.xpath("//strong[text()='Product description']")
                ).isDisplayed()
        );
    }


    public void verifyAddToCartButton() {
        Assert.assertTrue(
                "Add To Cart button should be displayed",
                driver.findElement(addToCartButton).isDisplayed()
        );
    }


    public void verifyNextPageDisplayed() {
        Assert.assertTrue(
                "Products should be displayed",
                driver.findElements(productCards).size() > 0
        );
    }


    public void verifyCartPageDisplayed() {
        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );
        Assert.assertTrue(
                "Cart page should be displayed",
                driver.getCurrentUrl().contains("cart.html")
        );
    }

    public void verifyLoginPopupDisplayed() {
        WebElement modal =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(loginModal)
                );
        Assert.assertTrue(
                "Login popup should be displayed",
                modal.isDisplayed()
        );
    }


    public void verifySignupPopupDisplayed() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupModal)
        );
        Assert.assertTrue(
                "Signup popup should be displayed",
                driver.findElement(signupModal).isDisplayed()
        );
    }

    public void verifyLoginUsernameFieldDisplayed() {
        Assert.assertTrue(
                "Login username field should be displayed",
                driver.findElement(loginUsername).isDisplayed()
        );
    }


    public void verifyLoginPasswordFieldDisplayed() {
        Assert.assertTrue(
                "Login password field should be displayed",
                driver.findElement(loginPassword).isDisplayed()
        );
    }

    public void verifySignupUsernameFieldDisplayed() {
        Assert.assertTrue(
                "Signup username field should be displayed",
                driver.findElement(signupUsername).isDisplayed()
        );
    }


    public void verifySignupPasswordFieldDisplayed() {
        Assert.assertTrue(
                "Signup password field should be displayed",
                driver.findElement(signupPassword).isDisplayed()
        );
    }


    public void verifyAboutUsPopupDisplayed() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(aboutUsModal)
        );
        Assert.assertTrue(
                "About Us popup should be displayed",
                driver.findElement(aboutUsModal).isDisplayed()
        );
    }


    public void verifyCompanyVideoDisplayed() {
        By video = By.id("example-video_html5_api");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(video)
        );
        Assert.assertTrue(
                "Company video should be displayed",
                driver.findElement(video).isDisplayed()
        );
    }
    public void goToSecondPage() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(prevButton));
    }

    public void clickPreviousButton() {
        wait.until(ExpectedConditions.elementToBeClickable(prevButton)).click();
    }

    public boolean isPreviousPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(products)
        ).size() > 0;
    }
}
