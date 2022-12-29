Feature: Login

  Scenario Outline: Login with wrong credentials
    Given User is on login page
    When User input username <username>
    And User input password <password>
    And User press login button
    Then Error notification will be shown
    Examples:
      | username        | password         |
      | "standard_user" | "wrong_password" |

  Scenario Outline: Login with valid credentials
    Given User is on login page
    When User input username <username>
    And User input password <password>
    And User press login button
    Then User is on home page
    Examples:
      | username        | password       |
      | "standard_user" | "secret_sauce" |
