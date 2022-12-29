package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.overviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class overviewDef extends baseTest {
    @And("user is on overviewpage")
    public void userIsOnOverviewPage() throws InterruptedException {
        overviewPage.validateOnPage();
    }

    @When("user click on finish button")
    public void userClickFinishButton() {
        overviewPage.finishButton();
    }
}
