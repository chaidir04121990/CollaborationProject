package challenge_appium.stepdef;

import challenge_appium.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

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

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.validateOnPage();
    }

    @Then("user can see error message")
    public void userSeenErrorMessage(){loginPage.validateErrorMessage();}
}
