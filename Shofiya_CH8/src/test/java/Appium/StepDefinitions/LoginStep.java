package Appium.StepDefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import Appium.Pages.LoginPage;
import Appium.BaseTest;

public class LoginStep extends BaseTest{
    LoginPage LoginPage = new LoginPage();

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        LoginPage.validateOnLoginPage();
    }

    @And("user input username with {word} username")
    public void userInputUsernameWith(String username) {
        LoginPage.inputUsername(username);
    }

    @And("user input password with {word} password")
    public void userInputPasswordWith(String password) {
        LoginPage.inputPassword(password);
    }

    @When("user click on login button")
    public void userClickLoginButton() {
        LoginPage.clickLoginButton();
    }

    @Then("user land on homepage")
    public void userLandOnProductPage(){
        LoginPage.validateOnHomepage();
    }

    @Then("error message will be display")
    public void errorUsernameOrPass(){
        LoginPage.showErrorMsg();
    }
}
