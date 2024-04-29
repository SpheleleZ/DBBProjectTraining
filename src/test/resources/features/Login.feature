@login
Feature: Login

# Registered user should be able to login to access Adactin Hotel

  Background:
    Given User is on Adactin Hotel login page build two
    And Verify login page build two is open

  Scenario Outline: Login with valid credentials
    When User enters valid username <username>
    And Enters valid password <password>
    And Click on login button
    Then user should be take to search Hotel page

    Examples:
      | username  | password   |
      | SpheleleZ | Nok2lasphe |

  Scenario Outline: Login with invalid username
    When User enters invalid username <username>
    And Enters valid password <password>
    And Click on login button
    Then User should get a proper warning message

    Examples:
      | username  | password   |
      | SpheleleZ | Nok2laSphe |

  Scenario Outline: Login with invalid password
    When User enters valid username <username>
    And Enters invalid password <password>
    And Click on login button
    Then User should get a proper warning message

    Examples:
      | username  | password   |
      | SpheleleZ | Nok2lasphe |