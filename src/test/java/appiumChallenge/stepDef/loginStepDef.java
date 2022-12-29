package appiumChallenge.stepDef;

import appiumChallenge.page.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;

public class loginStepDef {

    public loginPageFactory loginPage = new loginPageFactory();
    public inventoryPageFactory inventoryPage = new inventoryPageFactory();

    @Given("User is on login page")
    public void onLoginPage(){
        Assert.assertEquals((String) loginPage.checkPageNavBar(), "LOGIN");
    }

    @When("User input username {string}")
    public void inputUsername(String username){
        loginPage.inputUsername(username);
    }

    @And("User input password {string}")
    public void inputPassword(String password){
        loginPage.inputPassword(password);
    }

    @And("User press login button")
    public void pressLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("Error notification will be shown")
    public void checkError(){
        String errorMsg = loginPage.checkErrorMessage();
//        System.out.println(errorMsg);
        Assert.assertEquals(errorMsg, "Username and password do not match any user in this service.");
    }

}
