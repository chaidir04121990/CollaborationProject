package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.identityPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class identityDef extends baseTest {
    @Then("user is on identitypage")
    public void userIsOnIdentityPage() {
        identityPage.validateOnPage();
    }

    @And("user click on continue button")
    public void userClickContinueButton() {
        identityPage.clickContinueButton();
    }

    @Then("user found error message firstname is mandatory")
    public void firstnameIsMandatory() {
        identityPage.firstnameIsMandatory();
    }

    @Then("user found error message lastname is mandatory")
    public void lastnameIsMandatory() {
        identityPage.lastnameIsMandatory();
    }

    @Then("user found error message postalcode is mandatory")
    public void postalcodeIsMandatory() {
        identityPage.postalCodeIsMandatory();
    }

    @Then("user found error message all field is mandatory")
    public void allFieldIsMandatory() {
        identityPage.allFieldIsMandatory();
    }

    @And("user input firstname with {string}")
    public void userInputFirstname(String firstname) {
        identityPage.inputFirstname(firstname);
    }

    @And("user input lastname with {string}")
    public void userInputLastname(String lastname) {
        identityPage.inputLastname(lastname);
    }

    @And("user input postalcode with {string}")
    public void userInputPostalCode(String postalcode) {
        identityPage.inputPostalCode(postalcode);
    }
}
