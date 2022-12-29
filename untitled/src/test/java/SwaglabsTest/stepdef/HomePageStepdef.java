package SwaglabsTest.stepdef;

import SwaglabsTest.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;

public class HomePageStepdef {

    protected HomePage homePage;

    @And("User able to see products in homepage")
    public void userAbleToSeeProductsInHomepage(){
        homePage.validateOnPage();
    }

    @When("User click sorting button")
    public void userClickSortingButton(){
        homePage.clickSort();
    }

    @And("User click Price low to high")
    public void userClickPriceLowtoHigh(){
        homePage.selectLowtoHigh();
    }

    @Then("Page display item from low to high price")
    public void pageDisplayItemLowtoHigh(){
        homePage.itemLow();
        homePage.itemHigh();
        Assert.assertTrue(homePage.itemLow() < homePage.itemHigh());
    }

}
