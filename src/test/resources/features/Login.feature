@login
Feature: Login

# Registered user should be able to login to access Adactin Hotel

  Background:
    Given User is on Adactin Hotel login page build two

  Scenario Outline: Login with valid credentials
    When User enters valid username <username>
    And Enters valid password <password>
    And Click on login button
    Then user should be taken to the search Hotel page

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
      | Sphe12334 | Nok2lasphe |

  Scenario Outline: Login with no characters or empty username
    When User enters invalid username <username>
    And Enters valid password <password>
    And Click on login button
    Then User should get a message to enter Username

    Examples:
      | username | password   |
      |          | Nok2lasphe |

  Scenario Outline: Login with invalid or non registered password
    When User enters valid username <username>
    And Enters invalid password <password>
    And Click on login button
    Then User should get a proper warning message

    Examples:
      | username  | password   |
      | SpheleleZ | 3465tfggdd |

  Scenario Outline: Login with no characters or empty password
    When User enters invalid username <username>
    And Enters valid password <password>
    And Click on login button
    Then User should get a message to enter password

    Examples:
      | username  | password |
      | SpheleleZ |          |