package SwaglabsTest.stepdef;

import SwaglabsTest.BaseTest;
import SwaglabsTest.pages.HomePage;
import SwaglabsTest.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepdef extends BaseTest {

//    protected LoginPage loginPage;
//    protected HomePage homePage;

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User is on login page")
    public void userIsOnLoginPage(){
        Assert.assertNotNull(loginPage.validateOnPage());
    }

    @And("User input username with {string}")
    public void userInputUsernameWith(String username){
        loginPage.inputUsername(username);
    }

    @And("User input password with {string}")
    public void userInputPasswordWith(String password){
        loginPage.inputPassword(password);
    }

    @When("User click Login button")
    public void userClickLoginButton(){
        loginPage.clickLogin();
    }

    @Then("User is on homepage")
    public void userIsOnHomepage(){
        homePage.validateOnPage();
    }

    @Then("Show error message")
    public void showErrorMessage(){
        loginPage.errorMessage();
        Assert.assertEquals(loginPage.errorMessage(), "Username and password do not match any user in this service.");
    }
}
