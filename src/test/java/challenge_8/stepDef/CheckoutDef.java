package challenge_8.stepDef;

import challenge_8.BaseTest;
import challenge_8.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutDef extends BaseTest {

    // Scenario: User checkout two products
    // Given User land on Home page
    // And User has sorted product from low to high price
    // When User click Add to Cart button on product 1
    // And User click Add to Cart button on product 2
    // And User see two product added to cart
    // And User click on Cart button
    // And User land on Cart page
    // And User click Checkout button
    // And User land on Checkout Step One page
    // And User input First Name "Slamet"
    // And User input Last Name "Selalu"
    // And User input Postal Code "445677"
    // And User click Continue button
    // And User land on Checkout Step Two page
    // And User click Finish button
    // And User land on Checkout Complete page
    // Then User see success checkout message

    HomePage hp = new HomePage();
    CartPage cp = new CartPage();
    CheckoutSatuPage c1p = new CheckoutSatuPage();
    CheckoutDuaPage c2p = new CheckoutDuaPage();
    CheckoutCompletePage ccp = new CheckoutCompletePage();

    @Given("User has sorted product from low to high price")
    public void validateSorting() {
        System.out.println("User has sorted product from low to high price");
    }

    @When("User click Add to Cart button on product 1")
    public void addProduct1() {
        hp.addToCartProduct();
    }

    @And("User click Add to Cart button on product 2")
    public void addProduct2() {
        hp.addToCartProduct();
    }

    @And("User click on Cart button")
    public void clickCartBtn() {
        hp.clickCartBtn();
    }

    @And("User land on Cart page")
    public void onCartPage() {
        String text = cp.getCartText();
        Assert.assertEquals(text, "YOUR CART");
    }

    @And("User click Checkout button")
    public void clickCheckoutBtn() {
        cp.clickCheckoutBtn();
    }

    @And("User land on Checkout Step One page")
    public void onCheckoutStepOnePage() {
        c1p.onCheckoutSatuPage();
    }

    @And("User input First Name {string}")
    public void inputFirstName(String firstName) {
        c1p.inputFirstName(firstName);
    }

    @And("User input Last Name {string}")
    public void inputLastName(String lastName) {
        c1p.inputLastName(lastName);
    }

    @And("User input Postal Code {string}")
    public void inputPostalCode(String postalCode) {
        c1p.inputPostalCode(postalCode);
    }

    @And("User click Continue button")
    public void clickContinueBtn() {
        c1p.clickContinueBtn();
    }

    @And("User land on Checkout Step Two page")
    public void onCheckoutStepTwoPage() {
        c2p.onCheckoutDuaPage();
    }

    @And("User click Finish button")
    public void clickFinishBtn() {
        c2p.clickFinishBtn();
    }

    @And("User land on Checkout Complete page")
    public void onCheckoutCompletePage() {
        ccp.onCheckoutCompletePage();
    }

    @Then("User see success checkout message")
    public void successCheckoutMsg() {
        ccp.onCheckoutCompletePage();
    }
}
