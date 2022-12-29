package belajar.stepdef;

import belajar.Base;
import belajar.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sorting extends Base {

    HomePage homePage= new HomePage(wait,driver);
    @When("user click sorting button")
    public void userClickSortingButton() {
        homePage.clickSortButton();
    }

    @And("user press button")
    public void userPressButton() {
        homePage.clicklth();
    }

    @Then("product sorted from low to high")
    public void sortedLowToHigh() {
        homePage.validateSortLowToHigh();
    }
}
