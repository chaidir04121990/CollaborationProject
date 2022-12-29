package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.cartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class cartDef extends baseTest {
    CH8.pages.cartPage cartPage = new cartPage();

    @Then("user is on cartpage")
    public void userIsOnCartPage() {
        cartPage.validateOnPage();
    }

    @And("user click on checkout button")
    public void clickCheckoutButton() {
        cartPage.checkoutButton();
    }
}
