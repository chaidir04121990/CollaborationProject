package Appium.StepDefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import Appium.Pages.LoginPage;
import Appium.Pages.HomePage;
import Appium.BaseTest;

public class SortStep extends BaseTest{
    LoginPage LoginPage = new LoginPage();
    HomePage HomePage = new HomePage();

//    @Given("user is on login page")
//    public void userIsOnLoginPage() {
//
//        LoginPage.validateOnLoginPage();
//    }

//    @And("user input username with {string}")
//    public void userInputUsernameWith(String username) {
//        LoginPage.inputUsername(username);
//    }

//    @And("user input password with {string}")
//    public void userInputPasswordWith(String password) {
//        LoginPage.inputPassword(password);
//    }

//    @When("user click on login button")
//    public void userClickLoginButton() {
//        LoginPage.clickLoginButton();
//    }

//    @Then("user land on homepage")
//    public void userLandOnProductPage(){
//        LoginPage.validateOnHomepage();
//    }

    @When ("user click on sort item button")
    public void userClickSortButton(){
        HomePage.clickSortButton();
    }

    @And ("user click on sort items by price from high to low price")
    public void userClickFinishButton(){
        HomePage.clickFinishButton();
    }

//    @Then ("product sorted from high to low price")
}
