@Homepage
Feature: Homepage

  Background: User launch the app and login with registered account
    Given User is on login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click Login button
    Then User is on homepage

  Scenario: User sort items from low price to high price
    And User able to see products in homepage
    When User click sorting button
    And User click Price low to high
    Then Page display item from low to high price