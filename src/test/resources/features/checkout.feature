@checkout @regression
Feature: Checkout

  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click on login button
    Then user is on homepage

  @positive-test
  Scenario: 01 successful checkout with 6 products
    And user add 6 products to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage

  @positive-test
  Scenario: 02 successful checkout with 5 products
    And user add 5 products to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage

  @positive-test
  Scenario: 03 successful checkout with 4 products
    And user add 4 products to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage

  @positive-test
  Scenario: 04 successful checkout with 3 products
    And user add 3 products to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage

  @positive-test
  Scenario: 05 successful checkout with 2 products
    And user add 2 products to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage

  @positive-test @smoke
  Scenario: 06 successful checkout with 1 products
    And user add 1 product to the cart
    And user click on cart button
    Then user is on cartpage
    And user click on checkout button
    Then user is on identitypage
    And user input firstname with "Andreanov"
    And user input lastname with "Ridhovan"
    And user input postalcode with "12345"
    And user click on continue button
    And user is on overviewpage
    When user click on finish button
    Then user is on completepage