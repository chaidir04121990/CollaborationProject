@checkout
Feature: Checkout

  Background: User launch the app and login
    Given user is on login page
    And user input username with "standard_user" username
    And user input password with "secret_sauce" password
    When user click on login button
    Then user land on homepage

  Scenario: Checkout 2 products
    And user add item1 to the cart
    And user add item2 to the cart
    When user click shoppingcart button
    Then user is on cart page
    When user click checkout button
    Then user is on information page
    And user input firstname with "shofiya"
    And user input lastname with "khalisa"
    And user input postalcode with "1234"
    When user click continue button
    Then user is on overview page
    And user click finish button
    Then user land on complete page
