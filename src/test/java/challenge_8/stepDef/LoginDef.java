package challenge_8.stepDef;

import org.testng.Assert;

import challenge_8.BaseTest;
import challenge_8.page.HomePage;
import challenge_8.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginDef extends BaseTest {

//    Scenario: Login with valid credentials
//    Given User Navigate to "https://www.saucedemo.com/"
//    When User input Username "standard_user"
//    And User input Password "secret_sauce"
//    And User click Login button
//    Then User land on Home page

    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();

    @Given("User is on Login page")
    public void onLoginPage() {
        lp.driverPage.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.validateOnLoginPage();
        System.out.println("User is on Login page");
    }

    @When("User input Username {string}")
    public void inputUsername(String username) {
        lp.inputUsername(username);
        System.out.println("User input Username");
    }

    @And("User input Password {string}")
    public void inputPassword(String password) {
        lp.inputPassword(password);
        System.out.println("User input Password");
    }

    @And("User click Login button")
    public void clickLoginBtn(){
        lp.clickLoginButton();
        System.out.println("User click Login button");
    }

    @Then("User land on Home page")
    public void onHomePage() {
//        Assert.assertEquals(hp.productText(), "PRODUCTS");
        lp.driverPage.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        hp.onHomePage();
        System.out.println("User land on Home page");
    }

    @Then("User see error message")
    public void errorMsgShow(){
        lp.errorPasswordMsgShow();
    }
}
