package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    private int productCountBeforeDelete;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By cartMenu = By.id("cartur");

    By cartTable = By.cssSelector(".table");

    By picColumn = By.xpath("//th[text()='Pic']");
    By titleColumn = By.xpath("//th[text()='Title']");
    By priceColumn = By.xpath("//th[text()='Price']");

    By placeOrderButton = By.xpath("//button[text()='Place Order']");

    By productRows = By.xpath("//tbody[@id='tbodyid']/tr");

    By totalPrice = By.id("totalp");

    By homeMenu = By.id("nava");

    By placeOrderModal = By.id("orderModal");

    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By creditCardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");

    By purchaseBtn = By.xpath("//button[text()='Purchase']");

    By closeButton =
            By.xpath("//*[@id='orderModal']/div/div/div[3]/button[1]");

    By successMessage =
            By.xpath("//h2[text()='Thank you for your purchase!']");

    By confirmationDialog =
            By.cssSelector(".sweet-alert");

    By confirmationText =
            By.cssSelector(".lead.text-muted");

    public void openCart() {

        driver.navigate().to(
                "https://www.demoblaze.com/cart.html"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartTable
                )
        );
    }

    public void clickHomeMenu() {

        wait.until(
                ExpectedConditions.elementToBeClickable(homeMenu)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("index.html")
        );
    }

    public void clickPlaceOrder() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        placeOrderButton
                )
        ).click();
    }

    public void storeProductCount() {

        productCountBeforeDelete =
                driver.findElements(productRows).size();
    }

    public void deleteFirstProduct() {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        productRows
                )
        );

        int beforeCount =
                driver.findElements(productRows).size();

        WebElement deleteButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.linkText("Delete")
                        )
                );

        deleteButton.click();

        wait.until(driver -> {

            int afterCount =
                    driver.findElements(productRows).size();

            return afterCount < beforeCount;
        });
    }

    public void verifyCartPageDisplayed() {

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        Assert.assertTrue(
                "User is not on Cart page",
                driver.getCurrentUrl().contains("cart.html")
        );
    }

    public void verifyProductTableDisplayed() {

        Assert.assertTrue(
                driver.findElement(cartTable).isDisplayed()
        );
    }

    public void verifyPicColumnDisplayed() {

        Assert.assertTrue(
                driver.findElement(picColumn).isDisplayed()
        );
    }

    public void verifyTitleColumnDisplayed() {

        Assert.assertTrue(
                driver.findElement(titleColumn).isDisplayed()
        );
    }

    public void verifyPriceColumnDisplayed() {

        Assert.assertTrue(
                driver.findElement(priceColumn).isDisplayed()
        );
    }

    public void verifyPlaceOrderButtonDisplayed() {

        Assert.assertTrue(
                driver.findElement(placeOrderButton).isDisplayed()
        );
    }

    public void verifyProductExists() {

        wait.until(driver ->
                driver.findElements(productRows).size() > 0
        );

        List<WebElement> rows =
                driver.findElements(productRows);

        Assert.assertFalse(
                "No products found in cart",
                rows.isEmpty()
        );
    }

    public void verifyProductNameDisplayed() {

        WebElement productName =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//tbody[@id='tbodyid']/tr[1]/td[2]"
                                )
                        )
                );

        Assert.assertFalse(
                "Product name is empty",
                productName.getText()
                        .trim()
                        .isEmpty()
        );
    }

    public void verifyProductPriceDisplayed() {

        WebElement productPrice =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//tbody[@id='tbodyid']/tr[1]/td[3]"
                                )
                        )
                );

        Assert.assertFalse(
                "Product price is empty",
                productPrice.getText()
                        .trim()
                        .isEmpty()
        );
    }

    public void verifyTotalPriceDisplayed() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        totalPrice
                )
        );

        String total =
                driver.findElement(totalPrice)
                        .getText()
                        .trim();

        Assert.assertFalse(
                "Total price is empty",
                total.isEmpty()
        );
    }

    public void verifyTotalCalculation() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        totalPrice
                )
        );

        List<WebElement> prices =
                driver.findElements(
                        By.xpath("//tbody[@id='tbodyid']/tr/td[3]")
                );

        int expectedTotal = 0;

        for (WebElement price : prices) {

            expectedTotal +=
                    Integer.parseInt(
                            price.getText()
                                    .trim()
                    );
        }

        int actualTotal =
                Integer.parseInt(
                        driver.findElement(totalPrice)
                                .getText()
                                .trim()
                );

        Assert.assertEquals(
                "Total price calculation mismatch",
                expectedTotal,
                actualTotal
        );
    }

    public void verifyProductRemoved() {

        int currentCount =
                driver.findElements(productRows).size();

        Assert.assertEquals(
                "Product was not removed",
                productCountBeforeDelete - 1,
                currentCount
        );
    }

    public void verifyPlaceOrderPopupDisplayed() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        placeOrderModal
                )
        );

        Assert.assertTrue(
                driver.findElement(placeOrderModal)
                        .isDisplayed()
        );
    }

    public void verifyCartEmpty() {

        List<WebElement> rows =
                driver.findElements(productRows);

        Assert.assertEquals(
                "Cart is not empty",
                0,
                rows.size()
        );
    }

    public void verifyTotalZero() {

        String total =
                driver.findElement(totalPrice)
                        .getText()
                        .trim();

        Assert.assertTrue(
                total.isEmpty() || total.equals("0")
        );
    }

    public void verifyHomepageDisplayed() {

        wait.until(
                ExpectedConditions.urlContains(
                        "index.html"
                )
        );

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("index.html")
        );
    }

    public void verifyProductListDisplayed() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".card")
                )
        );

        List<WebElement> products =
                driver.findElements(
                        By.cssSelector(".card")
                );

        Assert.assertFalse(
                "Product list should not be empty",
                products.isEmpty()
        );
    }


    public boolean isNameFieldDisplayed() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        );

        return driver.findElement(nameField).isDisplayed();
    }

    public boolean isCountryFieldDisplayed() {

        return driver.findElement(countryField).isDisplayed();
    }

    public boolean isCityFieldDisplayed() {

        return driver.findElement(cityField).isDisplayed();
    }

    public boolean isCreditCardFieldDisplayed() {

        return driver.findElement(creditCardField).isDisplayed();
    }

    public boolean isMonthFieldDisplayed() {

        return driver.findElement(monthField).isDisplayed();
    }

    public boolean isYearFieldDisplayed() {

        return driver.findElement(yearField).isDisplayed();
    }

    public boolean isPurchaseButtonDisplayed() {

        return driver.findElement(purchaseBtn).isDisplayed();
    }

    public void clickCloseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(closeButton)
        ).click();
    }

    public boolean isPlaceOrderPopupClosed() {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        placeOrderModal
                )
        );
    }

    public void fillOrderInformation() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        );

        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys("Tania");

        driver.findElement(countryField).clear();
        driver.findElement(countryField).sendKeys("Indonesia");

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys("Sukabumi");

        driver.findElement(creditCardField).clear();
        driver.findElement(creditCardField).sendKeys("123456789");

        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys("06");

        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys("2026");
    }

    public void clickPurchaseButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(purchaseBtn)
        ).click();
    }

    public boolean isPurchaseSuccessMessageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        successMessage
                )
        ).isDisplayed();
    }

    public boolean isConfirmationDialogDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationDialog
                )
        ).isDisplayed();
    }

    public boolean isOrderIdDisplayed() {

        String text =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                confirmationText
                        )
                ).getText();

        return text.contains("Id:");
    }

    public boolean isPurchaseAmountDisplayed() {

        String text =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                confirmationText
                        )
                ).getText();

        return text.contains("Amount:");
    }

}
