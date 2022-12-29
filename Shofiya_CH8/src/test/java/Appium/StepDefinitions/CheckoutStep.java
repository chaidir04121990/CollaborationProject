package Appium.StepDefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import Appium.Pages.LoginPage;
import Appium.Pages.CheckoutPage;
import Appium.BaseTest;

public class CheckoutStep extends BaseTest{
    LoginPage LoginPage = new LoginPage();
    CheckoutPage CheckoutPage = new CheckoutPage();

//    @Given("user is on login page")
//    public void userIsOnLoginPage() {
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

//    @Then ("user is on homepage")
//    public void userIsOnHomepage(){
//        LoginPage.validateOnHomepage();
//    }

    @And ("user add item1 to the cart")
    public void userAddItem1(){
        CheckoutPage.clickItem1();
    }

    @And ("user add item2 to the cart")
    public void userAddItem2(){
        CheckoutPage.clickItem2();
    }

    @When ("user click shoppingcart button")
    public void userClickShoppingCartButton(){
        CheckoutPage.clickShoppingCart();
    }

    @Then ("user is on cart page")
    public void userIsOnCartPage(){
        CheckoutPage.validateOnCartPage();
    }

    @When ("user click checkout button")
    public void userClickCheckoutButton(){
        CheckoutPage.clickCheckoutButton();
    }

    @Then ("user is on information page")
    public void userIsOnInformationPage(){
        CheckoutPage.validateOnInformationPage();
    }

    @And ("user input firstname with {string}")
    public void userInputFirstnameWith(String firstname) {
        CheckoutPage.inputFirstname(firstname);
    }

    @And ("user input lastname with {string}")
    public void userInputLastnameWith(String lastname) {
        CheckoutPage.inputLastname(lastname);
    }

    @And ("user input postalcode with {string}")
    public void userInputPostalCodeWith(String postalcode) {
        CheckoutPage.inputPostalCode(postalcode);
    }

    @When ("user click continue button")
    public void userClickContinueButton(){
        CheckoutPage.clickContinueButton();
    }

    @Then ("user is on overview page")
    public void userIsOnOverviewPage(){
        CheckoutPage.validateOnOverviewPage();
    }

    @And ("user click finish button")
    public void userClickFinishButton(){
        CheckoutPage.clickFinishButton();
    }

    @Then ("user land on complete page")
    public void validateUserLandOnCompletePage(){
        CheckoutPage.validateTransactionWasSuccessful();
    }
}
