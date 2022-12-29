package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.completePage;
import io.cucumber.java.en.Then;

public class completeDef extends baseTest {
    @Then("user is on completepage")
    public void userIsOnHomePage() throws InterruptedException {
        completePage.validateOnPage();
    }
}
