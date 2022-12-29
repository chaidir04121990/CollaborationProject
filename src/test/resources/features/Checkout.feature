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

#  # Scenario: User add two products to cart
#  #   Given User has sorted product from low to high price
#  #   When User click Add to Cart button on product 1
#  #   And User click Add to Cart button on product 2
#  #   Then User see two product added to cart
#
#  # Scenario: User checkout product
#  #   Given User has added two product to cart
#  #   When User click on Cart button
#  #   And User click Checkout button
#  #   Then User land on Checkout Step One page
#
#  # Scenario: User fill information data
#  #   Given User is on Checkout Step One page
#  #   When User enter First Name "Slamet"
#  #   And User enter Last Name "Selalu"
#  #   And User enter Postal Code "445677"
#  #   And User click Continue button
#  #   Then User land on Checkout Step Two page
#
#  # Scenario: User finish checkout
#  #   Given User is on Checkout Step Two page
#  #   When User click Finish button
#  #   Then User is on Checkout Complete page
#  #   And User see success checkout message