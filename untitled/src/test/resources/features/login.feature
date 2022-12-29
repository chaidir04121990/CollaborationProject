@login
Feature: Login

  @positive-test
  Scenario Outline: Login with valid username and password
    Given User is on login page
    And User input username with <username>
    And User input password with <password>
    When User click Login button
    Then User is on homepage
    Examples:
      | username        | password       |
      | "standard_user" | "secret_sauce" |


  @negative-test
  Scenario Outline: Login with wrong password
    Given User is on login page
    And User input username with <username>
    And User input password with <password>
    When User click Login button
    Then Show error message
    Examples:
      | username        | password         |
      | "standard_user" | "wrong_password" |