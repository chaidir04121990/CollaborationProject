@sort @regression
Feature: Sort

  Scenario: Sorting from low to high
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click on login button
    Then user is on homepage
    When user click on sort button