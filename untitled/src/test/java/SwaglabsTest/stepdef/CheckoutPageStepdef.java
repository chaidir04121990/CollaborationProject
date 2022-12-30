package SwaglabsTest.stepdef;

import SwaglabsTest.pages.CheckoutPage;
import SwaglabsTest.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

public class CheckoutPageStepdef {
    protected CheckoutPage checkoutPage;
    protected HomePage homePage;

    @When("User add item 1 to cart")
    public void userAddItem1ToCart(){
        homePage.addCartItem1();
    }

    @And("User add item 2 to cart")
    public void userAddItem2ToCart(){
        homePage.addCartItem2();
    }

    @And("User click cart button")
    public void userClickCartButton(){
        homePage.cartButton();
    }

    @Then("User is on cart page")
    public void userIsOnCartPage(){
        checkoutPage.validateYourCartPage();
    }

    @When("User click checkout button")
    public void userClickCheckoutButton(){
        checkoutPage.checkoutButton();
    }

    @Then("User is on checkout information page")
    public void userIsOnCheckoutInformationPage(){
        checkoutPage.validateCheckoutInformationPage();
    }

    @And("User input first name with {string}")
    public void userInputFirstNameWith (String firstname){
        checkoutPage.inputFirstName(firstname);
    }

    @And("User input last name with {string}")
    public void userInputLastNameWith (String lastname){
        checkoutPage.inputLastName(lastname);
    }

    @And("User input postal code with {string}")
    public void userInputPostalCodeWith (String postalcode){
        checkoutPage.inputPostalCode(postalcode);
    }

    @When("User click continue button")
    public void userClickContinueButton(){
        checkoutPage.continueButton();
    }

    //server error
}
