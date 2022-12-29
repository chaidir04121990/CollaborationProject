package belajar.stepdef;

import belajar.Base;
import belajar.pages.CheckoutPage;
import belajar.pages.HomePage;
import belajar.pages.OverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Checkout extends Base {

    HomePage hp = new HomePage(wait,driver);
    CheckoutPage cp = new CheckoutPage(driver,wait);
    OverviewPage op = new OverviewPage(driver,wait);
    @When("user add first product")
    public void userAddFirstProduct() {
        hp.addFirstItem();
    }

    @And("user add second product")
    public void userAddSecondProduct() {
        hp.addSecondItem();
    }

    @And("validate total item")
    public void validateTotalItem() {
        String total = hp.validateTotalItem();
        Assert.assertEquals(total,"2");
    }

    @And("user click cart")
    public void userClickCart() {
        hp.clickCartButton();
    }

    @And("user click checkout")
    public void userClickCheckout() {
        cp.validateTitlePage1();
        cp.clickCheckout();
    }

    @Then("user on Information page")
    public void userOnInformationPage(){
        cp.validateInformationPage();
    }
    @When("user input first name {string}")
    public void inputFirstName(String firstName){
        cp.insertFirstName(firstName);
    }
    @And("user input last name {string}")
    public void inputLastName(String lastName){
        cp.insertLastName(lastName);
    }
    @And("user input postal code {string}")
    public void inputZipCode(String zipCode){
        cp.postalCode(zipCode);
    }

    @And("user click continue")
    public void clickContinue(){
        cp.clickContinue();
    }
    @Then("user on overview page")
    public void validateoveerviewPage(){
        op.validateOverviewPage();
    }
    @When("user click finish")
    public void clickFinish(){
        op.clickFinishButton();
    }

    @Then("user on thanks page")
    public void validateLastPage(){
        op.validateMessageSucces();
    }

}
