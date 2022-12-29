@checkout @regression
Feature: Checkout

  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click on login button
    Then user is on homepage

  @positive-test @smoke
  Scenario: 01 successful fill user identity
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    When user click on continue button
    Then user is on overviewpage

  @negative-test @smoke
  Scenario: 02 verify firstname field is mandatory
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with ""
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    When user click on continue button
    And user found error message firstname is mandatory

  @negative-test @smoke
  Scenario: 03 verify lastname field is mandatory
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with ""
    And user input postalcode with "12345"
    When user click on continue button
    And user found error message lastname is mandatory

  @negative-test @smoke
  Scenario: 04 verify postalcode field is mandatory
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with ""
    When user click on continue button
    And user found error message postalcode is mandatory

  @negative-test @smoke
  Scenario: 05 verify all field is mandatory
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with ""
    And user input lastname with ""
    And user input postalcode with ""
    When user click on continue button
    And user found error message all field is mandatory