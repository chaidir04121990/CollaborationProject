package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginDef extends baseTest {
    loginPage loginPage = new loginPage();

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.validateOnPage();
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user found error message invalid credentials")
    public void errorMessageInvalidCredentials(){
        loginPage.wrongCredentials();
    }

    @Then("user found error message locked account")
    public void errorMessageLockedAccount() {
        loginPage.checkLockedAccount();
    }

    @Then("user found error message username mandatory")
    public void errorMessageUsernameMandatory() {
        loginPage.checkUsernameIsMandatory();
    }

    @Then("user found error message password mandatory")
    public void errorMessagePasswordMandatory() {
        loginPage.checkPasswordIsMandatory();
    }

    @Then("user found error message all field mandatory")
    public void errorMessageAllFieldMandatory() {
        loginPage.checkAllFiedlIsMandatory();
    }
}
