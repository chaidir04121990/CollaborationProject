Feature: Sorting feature test

  Background: Login with valid credentials
    Given User is on login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User press login button
    Then User is on home page

  Scenario: User sort product from low to hi
    When User press sorting button
    And User press low to high "lohi" button
    Then Product sorted from low to high "lohi"
