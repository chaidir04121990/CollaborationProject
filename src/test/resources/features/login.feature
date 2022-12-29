Feature: Login

  Scenario Outline: login valid username and password
    Given user on login page
    And user input username with <username>
    And user input password with <password>
    When user click login button
    Then user on home page
    Examples:
      | username         | password       |
      | "standard_user"  | "secret_sauce" |
      | "problem_user" | "secret_sauce" |

  Scenario: login with invalid username and password
    Given user on login page
    And user input username with "standard"
    And user input password with "secret_sauce"
    When user click login button
    Then user get error message

