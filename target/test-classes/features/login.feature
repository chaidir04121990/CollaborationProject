@login @regression
Feature: Login

  Background :
  Given user is on login page

  @positive-test @smoke
  Scenario Outline: 01 Login with valid credentials
    And user input username with "<username>"
    And user input password with "<password>"
    When user click on login button
    Then user is on homepage
    Examples:
      | username | password |
      | standard_user | secret_sauce  |
      | problem_user | secret_sauce  |

  @negative-test
  Scenario Outline: 02 Login with wrong credentials
    And user input username with "<username>"
    And user input password with "<password>"
    When user click on login button
    Then user found error message invalid credentials
    Examples:
      | username | password |
      | secret_sauce | standard_user  |
      | secret_sauce | problem_user  |
      | secret_sauce | locked_out_user  |

  @negative-test
  Scenario: 03 Login with locked account credentials
    And user input username with "locked_out_user"
    And user input password with "secret_sauce"
    When user click on login button
    Then user found error message locked account

  @negative-test
  Scenario: 04 Login with empty username
    And user input username with ""
    And user input password with "secret_sauce"
    When user click on login button
    Then user found error message username mandatory

  @negative-test
  Scenario: 05 Login with empty password
    And user input username with "standard_user"
    And user input password with ""
    When user click on login button
    Then user found error message password mandatory

  @negative-test
  Scenario: 06 Login with empty all field
    And user input username with ""
    And user input password with ""
    When user click on login button
    Then user found error message all field mandatory