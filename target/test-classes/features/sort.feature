@sort @regression
Feature: Sort

  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click on login button
    Then user is on homepage
    And user click sort button

  @positive-test @smoke
  Scenario: 01 sort product from the lowest price
    When user click sort price low to high button
    Then user see list product from lowest price

  @positive-test @smoke
  Scenario: 02 sort product from the highest price
    When user click sort price high to low button
    Then user see list product from highest price

  @positive-test @smoke
  Scenario: 03 sort product alphabet asc
    When user click sort price A to Z button
    Then user see list product alphabet asc

  @positive-test @smoke
  Scenario: 04 sort product alphabet desc
    When user click sort price Z to A button
    Then user see list product alphabet desc