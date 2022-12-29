@sorting
Feature: Sorting

  Background: User launch the app and login
    Given user is on login page
    And user input username with "standard_user" username
    And user input password with "secret_sauce" password
    When user click on login button
    Then user land on homepage

  Scenario: Sort items from low to high price
    And user click on sort item button
    And user click on sort items by price from high to low price
    Then product sorted from high to low price