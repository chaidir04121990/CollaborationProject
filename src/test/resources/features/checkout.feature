Feature: Checkout

  Background: Login with valid credential
    Given user on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user on home page

  Scenario: user checkout 2 items
    When user add first product
    And user add second product
    And validate total item
    And user click cart
    And user click checkout
    Then user on Information page
    When user input first name "nizam"
    And user input last name "aditya"
    And user input postal code "12345"
    And user click continue
    Then user on overview page
    When user click finish
    Then user on thanks page
