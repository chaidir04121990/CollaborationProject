Feature: checkout

  Background: Login with valid credentials
    Given User is on login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User press login button
    And User is on home page
    And User press sorting button
    And User press sorting mode "lohi" button
    Then Product sorted with mode "lohi"


  Scenario Outline: User checkout product
    And User add <itemAmn> item to cart button
    And <itemAmn> Product added to cart
    And User click Cart Button
    And User is on <pageNavBar> page
    And User click on <buttonName> Button
    And User is on <pageNavBar1> page
    And User input <fieldName> field with <inputData>
    And User input <fieldName1> field with <inputData1>
    And User input <fieldName2> field with <inputData2>
    And User click on <buttonName1> Button
    And User is on <pageNavBar2> page
    And User click on <buttonName2> Button
    And User is on <pageNavBar3> page
    Examples:
      | itemAmn | pageNavBar  | buttonName | pageNavBar1             | fieldName    | inputData | fieldName1  | inputData1 | fieldName2 | inputData2 | buttonName1 | pageNavBar2          | buttonName2 | pageNavBar3           |
      | 2       | "YOUR CART" | "CHECKOUT" | "CHECKOUT: INFORMATION" | "First Name" | "Nama 1"  | "Last Name" | "Nama 1"   | "Zip Code" | "00000"    | "CONTINUE"  | "CHECKOUT: OVERVIEW" | "FINISH"    | "CHECKOUT: COMPLETE!" |
      | 4       | "YOUR CART" | "CHECKOUT" | "CHECKOUT: INFORMATION" | "First Name" | "Nama 2"  | "Last Name" | "Nama 2"   | "Zip Code" | "11111"    | "CONTINUE"  | "CHECKOUT: OVERVIEW" | "FINISH"    | "CHECKOUT: COMPLETE!" |

