package belajar.stepdef;

import belajar.Base;
import belajar.pages.HomePage;
import belajar.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef extends Base {
    LoginPage loginPage = new LoginPage(wait,driver);
    HomePage homePage = new HomePage(wait,driver);

    @Given("user on login page")
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

    @When("user click login button")
    public void userClickOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user on home page")
    public void userisOnHomePage(){
        homePage.validateOnPage();
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String message= loginPage.getMessage();
        Assert.assertEquals(message,"Username and password do not match any user in this service.");
    }
}
