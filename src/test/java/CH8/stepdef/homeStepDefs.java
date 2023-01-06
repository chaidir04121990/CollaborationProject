package CH8.stepdef;

import CH8.page.homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homeStepDefs {
    homePage homePage = new homePage();

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage.validateOnPage();
    }

    @When("user click on sort button")
    public void userClickOnSortButton(){homePage.user_click_on_sort_button();}
}

