package appiumChallenge.stepDef;

import appiumChallenge.page.ElementObj;
import appiumChallenge.page.inventoryPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class inventoryStepDef {

//    Scenario: User sort product from low to hi
//    Given User is on homepage
//    When User press sorting button
//    And User press low to high button
//    Then Product sorted from low to high


//    Given user is on homepage
//    When User press add to cart button from item 1
//    And User press add to cart button from item 2
//    And User press add to cart button from item 3
//    Then Product added to cart

    public inventoryPageFactory inventoryPage = new inventoryPageFactory();

    @Given("User is on home page")
    public void onHomepage() {
        Assert.assertEquals(inventoryPage.checkPageNavBar(), "PRODUCTS");
    }

    @When("User press sorting button")
    public void sortingParent() {
        inventoryPage.sortingParent();
    }

    @And("User press sorting mode {string} button")
    public void sortingMode(String mode) {
        inventoryPage.sortingMode(mode);
    }

    @Then("Product sorted with mode {string}")
    public void checkSorting(String mode) {
        List<ElementObj> itemsList = inventoryPage.getAllPrice();

        int var = 0;
        String mark = "";
        if (mode.equals("lohi")) { mark = "<="; }
        if (mode.equals("hilo")) { mark = ">="; }
        while (var < itemsList.size()-1){
            if (mode.equals("lohi")) { Assert.assertTrue(itemsList.get(var).getPrice() <= itemsList.get(var+1).getPrice()); }
            else if (mode.equals("hilo")) { Assert.assertTrue(itemsList.get(var).getPrice() >= itemsList.get(var+1).getPrice()); }
            var++;
        }
    }

    @When("User add {int} item to cart button")
    public void addtoCart(Integer itemAmn) {
        inventoryPage.addItems(itemAmn);
    }

    @Then("{int} Product added to cart")
    public void checkCart(int itemAmn) {
        Assert.assertEquals(itemAmn, inventoryPage.getCartNumber());
    }

    @And("User click Cart Button")
    public void clickCart() {
        inventoryPage.checkOut();
    }
}
