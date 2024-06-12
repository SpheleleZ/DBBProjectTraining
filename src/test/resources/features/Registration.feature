@Registration
Feature: Registration
# User should be able to register to Adactin Hotel

  Background:
    Given User is on Adactin Hotel login page build two
    And Click on New User Register Here link
    Then Verify registration page is open

  Scenario: New User Registration form
    When User enters registration details
      | Username       | Password  | ConfirmPassword | FullName     | EmailAddress    |
      | KitsoMabheleni | Kitso@123 | Kitso@123       | Kitso Mbhele | kitso@gmail.com |
    And Fill captcha text
    And Click on Terms and Conditions
    Then Click on register button
    And A page stating an email verification code has been sent to your email address should display