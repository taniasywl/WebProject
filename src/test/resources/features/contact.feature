@Contact
Feature: Contact Form

  Background:
    Given the user is on the homepage

  Scenario: Open Contact popup
    When the user clicks menu "Contact"
    Then the Contact popup should be displayed
    And the Contact Email field should be displayed
    And the Contact Name field should be displayed
    And the Message field should be displayed
    And the Send Message button should be displayed
    And the Close button should be displayed

  Scenario: Send contact message successfully
    Given the Contact popup is displayed
    When the user enters "test@mail.com" into the Contact Email field
    And the user enters "Tania" into the Contact Name field
    And the user enters "Hello, this is a test message" into the Message field
    And the user clicks button "Send Message"
    Then a success alert should be displayed

  Scenario: Close Contact popup
    Given the Contact popup is displayed
    When the user clicks button "Close"
    Then the Contact popup should be closed

  Scenario: Close Contact popup using X button
    Given the Contact popup is displayed
    When the user clicks the X icon
    Then the Contact popup should be closed