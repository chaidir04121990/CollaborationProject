@sorting
Feature: Sorting

  Scenario: Sort items from low to high price
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click on login button
    Then user is on homepage
    When user click on sort item button
    And user click on sort items by price from high to low price
    Then product sorted from high to low price