package challenge_8.stepDef;

import challenge_8.BaseTest;
import challenge_8.page.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingDef extends BaseTest {

    // Scenario: User sort product low to high price
    // Given User is on Home page
    // When User click on Filter button
    // And User click on Low to High Price button
    // Then User see product sorted from low to high price

    HomePage hp = new HomePage();

    @When("User click on Sorting button")
    public void clickSortingBtn() {
        hp.clickSortingBtn();
        System.out.println("User click on Sorting button");
    }

    @And("User click on Low to High Price button")
    public void sortLowToHighPrice() {
        hp.clickLowToHighBtn();
        System.out.println("User click on Low to High Price button");
    }

    @Then("User see products sorted from low to high price")
    public void validateSorting() {
        hp.validateSorting();
        System.out.println("User see products sorted from low to high price");
    }
}