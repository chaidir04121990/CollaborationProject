#@login @regression
#Feature: Login
#
#    @positive-test
#    Scenario Outline: Login with valid credentials
#        Given User is on Login page
#        When User input Username <username>
#        And User input Password <password>
#        And User click Login button
#        Then User land on Home page
#        Examples:
#            | username        | password       |
#            | "standard_user" | "secret_sauce" |
#
#    @negative-test
#    Scenario Outline: Login with wrong password
#        Given User is on Login page
#        When User input Username <username>
#        And User input Password <password>
#        And User click Login button
#        Then User see error message
#        Examples:
#            | username        | password         |
#            | "standard_user" | "wrong_password" |