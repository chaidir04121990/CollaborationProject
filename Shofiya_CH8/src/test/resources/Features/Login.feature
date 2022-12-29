@login @regression
Feature: Login

  @possitive-test @smoke
  Scenario Outline: Login with valid credentials
    Given user is on login page
    And user input username with <username> username
    And user input password with <password> password
    When user click on login button
    Then user land on homepage
    Examples:
      | username          | password       |
      | "standard_user"   | "secret_sauce" |
      | "locked_out_user" | "secret_sauce" |
      | "problem_user"    | "secret_sauce" |

 @negative-test
 Scenario: Login with wrong credentials
    Given user is on login page
    And user input username with "standard_user" username
    And user input password with "wrong_password" password
    When user click on login button
    Then error message will be display