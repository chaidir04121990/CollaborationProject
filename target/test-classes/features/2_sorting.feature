Feature: Sorting feature test

  Background: Login with valid credentials
    Given User is on login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User press login button
    Then User is on home page

  Scenario Outline: User sort product from low to hi
    When User press sorting button
    And User press sorting mode <mode> button
    Then Product sorted with mode <mode>
    Examples:
      | mode   |
      | "lohi" |
      | "hilo" |
