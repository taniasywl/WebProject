@AboutUs
Feature: About Us

  Background:
    Given the user is on the homepage

  Scenario: Open About Us popup
    When the user clicks menu "About us"
    Then the About Us popup should be displayed
    And the company profile video should be displayed
    And the Play button should be displayed
    And the About Us Close button should be displayed

  Scenario: Play About Us video
    Given the About Us popup is displayed
    When the user clicks About Us button "Play"
    Then the video should start playing

  Scenario: Pause About Us video
    Given the video is playing
    When the user clicks About Us button "Pause"
    Then the video should be paused

  Scenario: Close About Us popup using Close button
    Given the About Us popup is displayed
    When the user clicks About Us button "Close"
    Then the About Us popup should be closed

  Scenario: Close About Us popup using X button
    Given the About Us popup is displayed
    When the user clicks the About Us X icon
    Then the About Us popup should be closed

  Scenario: Verify video element is displayed
    Given the About Us popup is displayed
    Then the video should be displayed
    And the video controls should be available

  Scenario: Reopen About Us popup after closing
    Given the user has closed the About Us popup
    When the user clicks menu "About us"
    Then the About Us popup should be displayed again