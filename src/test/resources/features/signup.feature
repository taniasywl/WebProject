@Signup
Feature: Sign Up Demoblaze

  Background:
    Given the user is on the demoblaze homepage

  Scenario: User signs up with a valid username and password
    When the user clicks the Sign Up button
    And the user enters a username "cortis124"
    And the user enters a password "tania123"
    And clicks the Sign Up submit button
    Then the user should see a successful signup alert
    And the user clicks "OK" on the alert
    And the Sign Up popup should be closed
    And the user should remain on the homepage

  Scenario: User signs up with an existing username
    When the user clicks the Sign Up button
    And the user enters a username "taniasywl"
    And the user enters a password "tania124"
    And clicks the Sign Up submit button
    Then the user should see an existing user alert
    And the user clicks "OK" on the alert
    And the user should remain on the homepage

  Scenario: Close Sign Up popup
    When the user clicks the Sign Up button
    Then the Sign Up popup should be displayed
    When the user clicks the Close button
    Then the Sign Up popup should be closed

  Scenario: Close Sign Up popup using X button
    When the user clicks the Sign Up button
    Then the Sign Up popup should be displayed
    When the user clicks the Sign Up X icon
    Then the Sign Up popup should be closed

  Scenario: User signs up with empty username
    When the user clicks the Sign Up button
    And the user enters a username ""
    And the user enters a password "tania123"
    And clicks the Sign Up submit button
    Then the user should see a signup validation alert

  Scenario: User signs up with empty password
    When the user clicks the Sign Up button
    And the user enters a username "kukang13"
    And the user enters a password ""
    And clicks the Sign Up submit button
    Then the user should see a signup validation alert

  Scenario: User signs up with empty username and password
    When the user clicks the Sign Up button
    And clicks the Sign Up submit button
    Then the user should see a signup validation alert