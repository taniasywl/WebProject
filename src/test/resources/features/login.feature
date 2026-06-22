@Login
Feature: Login Feature

  Background:
    Given the user is on the demoblaze homepage

  Scenario: User Login with registered account
    When the user clicks the "Login" button
    And the user enters login username "taniasywl"
    And the user enters login password "tania123"
    And the user clicks the "Login Submit" button
    Then the user should be successfully logged in
    And the user should see "Welcome taniasywl" on the navigation bar
    And the user should remain on the homepage

  Scenario: User Login with unregistered account
    When the user clicks the "Login" button
    And the user enters login username "putri345"
    And the user enters login password "cantik89"
    And the user clicks the "Login Submit" button
    Then the user should see an invalid login alert
    And the user clicks "OK" on the alert
    And the user should remain on the homepage

  Scenario: User Login with incorrect password
    When the user clicks the "Login" button
    And the user enters login username "taniasywl"
    And the user enters login password "wrongpassword"
    And the user clicks the "Login Submit" button
    Then the user should see an invalid login alert
    And the user clicks "OK" on the alert
    And the user should remain on the homepage

  Scenario: User Login with empty username
    When the user clicks the "Login" button
    And the user enters login username ""
    And the user enters login password "tania123"
    And the user clicks the "Login Submit" button
    Then the user should see a login validation alert

  Scenario: User Login with empty password
    When the user clicks the "Login" button
    And the user enters login username "taniasywl"
    And the user enters login password ""
    And the user clicks the "Login Submit" button
    Then the user should see a login validation alert

  Scenario: Close Login popup using Close button
    When the user clicks the "Login" button
    Then the Login popup should be displayed
    When the user clicks the "Close" button
    Then the Login popup should be closed

  Scenario: User Logout successfully
    Given the user is logged in
    When the user clicks the "Logout" button
    Then the user should be logged out
    And the "Log in" button should be displayed
    And the "Sign up" button should be displayed