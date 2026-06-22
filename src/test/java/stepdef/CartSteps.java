package stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.HomePage;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class CartSteps {
    HomePage homePage = new HomePage(BaseTest.driver);
    CartPage cartPage = new CartPage(BaseTest.driver);

    private void acceptAlert() {
        WebDriverWait wait =
                new WebDriverWait(
                        BaseTest.driver,
                        Duration.ofSeconds(10)
                );
        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent()
                );
        alert.accept();
    }

    @Given("the user has added a product to the cart")
    public void the_user_has_added_a_product_to_the_cart() {
        homePage.openHomepage();
        homePage.clickProduct("Samsung galaxy s6");
        homePage.clickButton("Add to cart");
        acceptAlert();
    }

    @Given("the user has a product in the cart")
    public void the_user_has_a_product_in_the_cart() {
        homePage.openHomepage();
        homePage.clickProduct("Samsung galaxy s6");
        homePage.clickButton("Add to cart");
        acceptAlert();
        cartPage.openCart();
    }

    @Given("the user has multiple products in the cart")
    public void the_user_has_multiple_products_in_the_cart() {
        homePage.openHomepage();

        homePage.clickProduct("Samsung galaxy s6");
        homePage.clickButton("Add to cart");
        acceptAlert();

        BaseTest.driver.navigate().to(
                "https://www.demoblaze.com/index.html"
        );

        homePage.clickProduct("Nokia lumia 1520");
        homePage.clickButton("Add to cart");
        acceptAlert();

        cartPage.openCart();
    }

    @Given("the user has no products in the cart")
    public void the_user_has_no_products_in_the_cart() {
        cartPage.openCart();
        while (!BaseTest.driver.findElements(
                By.linkText("Delete")
        ).isEmpty()) {
            BaseTest.driver.findElement(
                    By.linkText("Delete")
            ).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Given("the user is on the Cart page")
    public void the_user_is_on_the_cart_page() {
        cartPage.openCart();
    }

    @When("the user opens the Cart page")
    public void the_user_opens_the_cart_page() {
        cartPage.openCart();
    }

    @When("the user clicks the Delete button for a product")
    public void the_user_clicks_the_delete_button_for_a_product() {
        cartPage.storeProductCount();
        cartPage.deleteFirstProduct();
    }

    @When("the user removes all products from the cart")
    public void the_user_removes_all_products_from_the_cart() {

        while (!BaseTest.driver.findElements(
                By.linkText("Delete")
        ).isEmpty()) {
            BaseTest.driver.findElement(
                    By.linkText("Delete")
            ).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @When("the user clicks the Place Order button")
    public void the_user_clicks_the_place_order_button() {
        cartPage.clickPlaceOrder();
    }

    @Then("the product table should be displayed")
    public void the_product_table_should_be_displayed() {
        cartPage.verifyProductTableDisplayed();
    }

    @Then("the Pic column should be displayed")
    public void the_pic_column_should_be_displayed() {
        cartPage.verifyPicColumnDisplayed();
    }

    @Then("the Title column should be displayed")
    public void the_title_column_should_be_displayed() {
        cartPage.verifyTitleColumnDisplayed();
    }

    @Then("the Price column should be displayed")
    public void the_price_column_should_be_displayed() {
        cartPage.verifyPriceColumnDisplayed();
    }

    @Then("the Place Order button should be displayed")
    public void the_place_order_button_should_be_displayed() {
        cartPage.verifyPlaceOrderButtonDisplayed();
    }

    @Then("the added product should be displayed")
    public void the_added_product_should_be_displayed() {
        cartPage.verifyProductExists();
    }

    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {
        cartPage.verifyProductNameDisplayed();
    }

    @Then("the cart product price should be displayed")
    public void the_cart_product_price_should_be_displayed() {
        cartPage.verifyProductPriceDisplayed();
    }

    @Then("the total price should be displayed")
    public void the_total_price_should_be_displayed() {
        cartPage.verifyTotalPriceDisplayed();
    }

    @Then("the total price should equal the sum of all product prices in the cart")
    public void the_total_price_should_equal_the_sum_of_all_product_prices_in_the_cart() {
        cartPage.verifyTotalCalculation();
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        cartPage.verifyProductRemoved();
    }

    @Then("the total price should be updated")
    public void the_total_price_should_be_updated() {
        cartPage.verifyTotalZero();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        cartPage.verifyCartEmpty();
    }

    @Then("the total price should be 0")
    public void the_total_price_should_be_0() {
        cartPage.verifyTotalZero();
    }

    @Then("the Place Order popup should be displayed")
    public void the_place_order_popup_should_be_displayed() {
        cartPage.verifyPlaceOrderPopupDisplayed();
    }

    @Then("no products should be displayed")
    public void no_products_should_be_displayed() {
        cartPage.verifyCartEmpty();
    }

    @Then("the homepage should be displayed")
    public void the_homepage_should_be_displayed() {
        cartPage.verifyHomepageDisplayed();
        homePage.verifyLogoDisplayed();
    }

    @When("the user clicks Home menu from Cart")
    public void the_user_clicks_home_menu_from_cart() {
        cartPage.clickHomeMenu();
    }

    @Then("the Name field should be displayed")
    public void verifyNameFieldDisplayed() {
        assertTrue(cartPage.isNameFieldDisplayed());
    }

    @Then("the Country field should be displayed")
    public void verifyCountryFieldDisplayed() {
        assertTrue(cartPage.isCountryFieldDisplayed());
    }

    @Then("the City field should be displayed")
    public void verifyCityFieldDisplayed() {
        assertTrue(cartPage.isCityFieldDisplayed());
    }

    @Then("the Credit Card field should be displayed")
    public void verifyCreditCardFieldDisplayed() {
        assertTrue(cartPage.isCreditCardFieldDisplayed());
    }

    @Then("the Month field should be displayed")
    public void verifyMonthFieldDisplayed() {
        assertTrue(cartPage.isMonthFieldDisplayed());
    }

    @Then("the Year field should be displayed")
    public void verifyYearFieldDisplayed() {
        assertTrue(cartPage.isYearFieldDisplayed());
    }

    @Then("the Purchase button should be displayed")
    public void verifyPurchaseButtonDisplayed() {
        assertTrue(cartPage.isPurchaseButtonDisplayed());
    }

    @When("the user clicks the Place Order Close button")
    public void the_user_clicks_the_place_order_close_button() {
        cartPage.clickCloseButton();
    }

    @Then("the Place Order popup should be closed")
    public void verifyPlaceOrderPopupClosed() {
        assertTrue(cartPage.isPlaceOrderPopupClosed());
    }

    @When("the user enters valid order information")
    public void enterValidOrderInformation() {
        cartPage.fillOrderInformation();
    }

    @When("the user clicks Purchase button")
    public void clickPurchaseButton() {
        cartPage.clickPurchaseButton();
    }

    @Then("a purchase success message should be displayed")
    public void verifyPurchaseSuccessMessageDisplayed() {
        assertTrue(cartPage.isPurchaseSuccessMessageDisplayed());
    }

    @Then("the confirmation dialog should be displayed")
    public void verifyConfirmationDialogDisplayed() {
        assertTrue(cartPage.isConfirmationDialogDisplayed());
    }

    @Then("the order id should be displayed")
    public void verifyOrderIdDisplayed() {
        assertTrue(cartPage.isOrderIdDisplayed());
    }

    @Then("the purchase amount should be displayed")
    public void verifyPurchaseAmountDisplayed() {
        assertTrue(cartPage.isPurchaseAmountDisplayed());
    }
}
