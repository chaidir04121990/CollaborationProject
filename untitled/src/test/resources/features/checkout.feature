@Checkout
Feature: Checkout
  Background: User launch the app and login with registered account
    Given User is on login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click Login button
    Then User is on homepage

  Scenario Outline: Checkout 2 different items
    And User able to see products in homepage
    When User add item 1 to cart
    And User add item 2 to cart
    And User click cart button
    Then User is on cart page
    When User click checkout button
    Then User is on checkout information page
    And User input first name with <firstName>
    And User input last name with <lastName>
    And User input postal code with <postalCode>
    When User click continue button
    Then User is on checkout overview page
    When User click finish button
    Then User is on checkout complete page
    Examples:
      | firstName | lastName | postalCode |
      | "Lala"    | "Lili"   | "12345"    |