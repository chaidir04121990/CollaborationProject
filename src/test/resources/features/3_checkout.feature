Feature: checkout

  Background: Login with valid credentials
    Given User is on login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User press login button
    And User is on home page
    And User press sorting button
    And User press low to high "lohi" button
    Then Product sorted from low to high "lohi"


  Scenario: User checkout product
    And User press add to cart button from item 1
    And User press add to cart button from item 2
    And Product added to cart
    And User click Cart Button
    And User is on "YOUR CART" page
    And User click on "CHECKOUT" Button
    And User is on "CHECKOUT: INFORMATION" page
    And User input "First Name" field with "Nama 1"
    And User input "Last Name" field with "Nama 2"
    And User input "Zip Code" field with "00000"
    And User click on "CONTINUE" Button
    And User is on "CHECKOUT: OVERVIEW" page
    And User click on "FINISH" Button
    And User is on "CHECKOUT: COMPLETE!" page

