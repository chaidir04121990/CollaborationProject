package challenge_appium.stepdef;

import challenge_appium.page.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefs {
    HomePage homePage = new HomePage();

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage.validateOnPage();
    }

    @When("user click on sort button")
    public void userClickOnSortButton(){homePage.user_click_on_sort_button();}
}