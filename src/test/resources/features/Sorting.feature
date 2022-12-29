@sorting
Feature: Sorting

  Background: User is logged in
    Given User is on Login page
    When User input Username "standard_user"
    And User input Password "secret_sauce"
    And User click Login button
    Then User land on Home page

  Scenario: User sort product low to high price
    When User click on Sorting button
    And User click on Low to High Price button
    Then User see products sorted from low to high price