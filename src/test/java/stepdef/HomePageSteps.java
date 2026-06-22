package stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;


import page.HomePage;

import static stepdef.BaseTest.driver;


public class HomePageSteps {
    HomePage homepage = new HomePage(driver);


    @Given("the user opens the Demoblaze homepage")
    public void openHomepage() {
        homepage.openHomepage();
    }


    @Then("the Product Store logo should be displayed")
    public void verifyLogoDisplayed() {
        homepage.verifyLogoDisplayed();
    }


    @Then("the navigation menu should be displayed")
    public void verifyNavigationMenuDisplayed() {
        homepage.verifyNavigationMenuDisplayed();
    }


    @Then("the category section should be displayed")
    public void verifyCategorySectionDisplayed() {
        homepage.verifyCategorySectionDisplayed();
    }


    @Then("the product list should be displayed")
    public void verifyProductListDisplayed() {
        homepage.verifyProductListDisplayed();
    }


    @Then("category {string} should be displayed")
    public void verifyCategoryDisplayed(String category) {
        homepage.verifyCategoryDisplayed(category);
    }


    @Then("product cards should be displayed")
    public void verifyProductCardsDisplayed() {
        homepage.verifyProductCardsDisplayed();
    }


    @Then("each product should display image, title, and price")
    public void verifyProductInformationDisplayed() {
        homepage.verifyProductInformationDisplayed();
    }


    @When("the user clicks the next banner button")
    public void clickNextBannerButton() {
        homepage.clickNextBanner();
    }


    @Then("the banner should change")
    public void verifyBannerChanged() {
        homepage.verifyBannerChanged();
    }


    @When("the user clicks category {string}")
    public void clickCategory(String category) {
        homepage.clickCategory(category);
    }


    @Then("phone products should be displayed")
    public void verifyPhoneProductsDisplayed() {
        homepage.verifyProductsDisplayed();
    }


    @Then("laptop products should be displayed")
    public void verifyLaptopProductsDisplayed() {
        homepage.verifyProductsDisplayed();
    }


    @Then("monitor products should be displayed")
    public void verifyMonitorProductsDisplayed() {
        homepage.verifyProductsDisplayed();
    }


    @Then("product {string} should be displayed")
    public void verifyProductDisplayed(String productName) {
        homepage.verifyProductDisplayed(productName);
    }


    @Then("the total number of phone products should be {int}")
    public void verifyPhoneProductCount(int count) {
        homepage.verifyProductCount(count);
    }


    @Then("the total number of monitor products should be {int}")
    public void verifyMonitorProductCount(int count) {
        homepage.verifyProductCount(count);
    }


    @When("the user clicks product {string}")
    public void clickProduct(String productName) {
        homepage.clickProduct(productName);
    }


    @Then("the product detail page should be displayed")
    public void verifyProductDetailPageDisplayed() {
        homepage.verifyProductDetailPageDisplayed();
    }


    @Then("the product name should be {string}")
    public void verifyProductName(String productName) {
        homepage.verifyProductName(productName);
    }


    @Then("the product price should be displayed")
    public void verifyProductPriceDisplayed() {
        homepage.verifyProductPrice();
    }


    @Then("the product description should be displayed")
    public void verifyProductDescriptionDisplayed() {
        homepage.verifyProductDescription();
    }


    @Then("the Add to Cart button should be displayed")
    public void verifyAddToCartButtonDisplayed() {
        homepage.verifyAddToCartButton();
    }


    @When("the user clicks the Next button")
    public void clickNextButton() {
        homepage.clickButton("Next");
    }


    @Then("the next page of products should be displayed")
    public void verifyNextPageDisplayed() {
        homepage.verifyNextPageDisplayed();
    }




    @Then("the Cart page should be displayed")
    public void verifyCartPageDisplayed() {
        homepage.verifyCartPageDisplayed();
    }


    @Then("the Login popup should be displayed")
    public void verifyLoginPopupDisplayed() {
        homepage.verifyLoginPopupDisplayed();
    }


    @Then("username field should be displayed")
    public void verifyUsernameFieldDisplayed() {
        homepage.verifyLoginUsernameFieldDisplayed();
    }


    @Then("password field should be displayed")
    public void verifyPasswordFieldDisplayed() {
        homepage.verifyLoginPasswordFieldDisplayed();
    }


    @Then("the Sign Up popup should be displayed")
    public void verifySignUpPopupDisplayed() {
        homepage.verifySignupPopupDisplayed();
    }


    @Then("signup username field should be displayed")
    public void verifySignupUsernameFieldDisplayed() {
        homepage.verifySignupUsernameFieldDisplayed();
    }


    @Then("signup password field should be displayed")
    public void verifySignupPasswordFieldDisplayed() {
        homepage.verifySignupPasswordFieldDisplayed();
    }


    @Then("the About Us popup should be displayed")
    public void verifyAboutUsPopupDisplayed() {
        homepage.verifyAboutUsPopupDisplayed();
    }


    @Then("the company profile video should be displayed")
    public void verifyCompanyVideoDisplayed() {
        homepage.verifyCompanyVideoDisplayed();
    }

    @When("the user clicks menu {string}")
    public void clickMenu(String menu) {
        homepage.clickMenu(menu);
    }

    @Given("the user is on the second page of products")
    public void theUserIsOnTheSecondPageOfProducts() {
        homepage.goToSecondPage();
    }

    @When("the user clicks the Previous button")
    public void theUserClicksThePreviousButton() {
        homepage.clickPreviousButton();
    }

    @Then("the previous page of products should be displayed")
    public void thePreviousPageOfProductsShouldBeDisplayed() {
        Assert.assertTrue(homepage.isPreviousPageDisplayed());
    }
}
