@checkout
Feature: Checkout

  Background: User has logged in and sorted product from low to high price
    Given User is on Login page
    When User input Username "standard_user"
    And User input Password "secret_sauce"
    And User click Login button
    And User land on Home page
    And User click on Sorting button
    And User click on Low to High Price button
    Then User see products sorted from low to high price

  Scenario: User checkout two products
    When User click Add to Cart button on product 1
    And User click Add to Cart button on product 2
    And User click on Cart button
    And User land on Cart page
    And User click Checkout button
    And User land on Checkout Step One page
    And User input First Name "Slamet"
    And User input Last Name "Selalu"
    And User input Postal Code "445677"
    And User click Continue button
    And User land on Checkout Step Two page
    And User click Finish button
    And User land on Checkout Complete page
    Then User see success checkout message