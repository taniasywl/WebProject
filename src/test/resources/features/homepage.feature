@Homepage
Feature: Homepage Product Store

  Background:
    Given the user opens the Demoblaze homepage

  Scenario: User can view homepage successfully
    Then the Product Store logo should be displayed
    And the navigation menu should be displayed
    And the category section should be displayed
    And the product list should be displayed

  Scenario: User can view available product categories
    Then category "Phones" should be displayed
    And category "Laptops" should be displayed
    And category "Monitors" should be displayed

  Scenario: User can view product information
    Then product cards should be displayed
    And each product should display image, title, and price

  Scenario: User can navigate banner slider
    When the user clicks the next banner button
    Then the banner should change

  Scenario: User can filter products by Phones category
    When the user clicks category "Phones"
    Then phone products should be displayed

  Scenario: User can filter products by Laptops category
    When the user clicks category "Laptops"
    Then laptop products should be displayed

  Scenario: User can filter products by Monitors category
    When the user clicks category "Monitors"
    Then monitor products should be displayed

  Scenario: User can open a product detail page
    When the user clicks product "Samsung galaxy s6"
    Then the product detail page should be displayed
    And the product name should be "Samsung galaxy s6"
    And the product price should be displayed
    And the product description should be displayed
    And the Add to Cart button should be displayed

  Scenario: User can navigate to next product page
    When the user clicks the Next button
    Then the next page of products should be displayed

  Scenario: User can open Cart page
    When the user clicks menu "Cart"
    Then the Cart page should be displayed

  Scenario: User can open Login popup
    When the user clicks menu "Log in"
    Then the Login popup should be displayed
    And username field should be displayed
    And password field should be displayed

  Scenario: User can open Sign Up popup
    When the user clicks menu "Sign up"
    Then the Sign Up popup should be displayed
    And signup username field should be displayed
    And signup password field should be displayed

  Scenario: User can open About Us popup
    When the user clicks menu "About us"
    Then the About Us popup should be displayed
    And the company profile video should be displayed

  Scenario: User can navigate to previous product page
    Given the user is on the second page of products
    When the user clicks the Previous button
    Then the previous page of products should be displayed

  Scenario: User can open Contact popup
    When the user clicks menu "Contact"
    Then the Contact popup should be displayed
    And the Contact Email field should be displayed
    And the Contact Name field should be displayed
    And the Message field should be displayed


