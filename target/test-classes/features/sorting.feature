Feature: Sorting

  Background: Login with valid credential
    Given user on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user on home page

  Scenario: User sort product
    When user click sorting button
    And user press button
    Then product sorted from low to high