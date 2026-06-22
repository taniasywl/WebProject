@Cart
Feature: Shopping Cart

  Background:
    Given the user is on the homepage

  Scenario: Open cart page
    When the user clicks menu "Cart"
    Then the Cart page should be displayed
    And the product table should be displayed
    And the Pic column should be displayed
    And the Title column should be displayed
    And the Price column should be displayed
    And the Place Order button should be displayed

  Scenario: Cart displays added product
    Given the user has added a product to the cart
    When the user opens the Cart page
    Then the added product should be displayed
    And the product name should be displayed
    And the cart product price should be displayed

  Scenario: Verify total price calculation
    Given the user has added a product to the cart
    When the user opens the Cart page
    Then the total price should be displayed
    And the total price should equal the sum of all product prices in the cart

  Scenario: Remove product from cart
    Given the user has a product in the cart
    When the user clicks the Delete button for a product
    Then the product should be removed from the cart
    And the total price should be updated

  Scenario: Remove all products from cart
    Given the user has multiple products in the cart
    When the user removes all products from the cart
    Then the cart should be empty
    And the total price should be 0

  Scenario: Place order with product in cart
    Given the user has a product in the cart
    When the user clicks the Place Order button
    Then the Place Order popup should be displayed

  Scenario: Verify cart is empty
    Given the user has no products in the cart
    When the user opens the Cart page
    Then no products should be displayed
    And the total price should be 0

  Scenario: Navigate to Home from Cart
    Given the user is on the Cart page
    When the user clicks Home menu from Cart
    Then the homepage should be displayed
    And the product list should be displayed

  Scenario: Verify Place Order popup fields
    Given the user has a product in the cart
    When the user clicks the Place Order button
    Then the Place Order popup should be displayed
    And the Name field should be displayed
    And the Country field should be displayed
    And the City field should be displayed
    And the Credit Card field should be displayed
    And the Month field should be displayed
    And the Year field should be displayed
    And the Purchase button should be displayed

  Scenario: Close Place Order popup
    Given the user has a product in the cart
    When the user clicks the Place Order button
    And the user clicks the Place Order Close button
    Then the Place Order popup should be closed

  Scenario: Purchase product successfully
    Given the user has a product in the cart
    When the user clicks the Place Order button
    And the user enters valid order information
    And the user clicks Purchase button
    Then a purchase success message should be displayed

  Scenario: Verify purchase confirmation details
    Given the user has a product in the cart
    When the user clicks the Place Order button
    And the user enters valid order information
    And the user clicks Purchase button
    Then the confirmation dialog should be displayed
    And the order id should be displayed
    And the purchase amount should be displayed