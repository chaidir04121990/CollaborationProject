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

    @And("User press low to high {string} button")
    public void sortingMode(String mode) {
        inventoryPage.sortingMode(mode);
    }

    @Then("Product sorted from low to high {string}")
    public void checkSorting(String mode) {
        List<ElementObj> itemsList = inventoryPage.getAllPrice();

        int var = 0;
        String mark = "";
        if (mode.equals("lohi")) { mark = "<="; }
        if (mode.equals("hilo")) { mark = ">="; }
        while (var < itemsList.size()-1){
//            System.out.printf("%f %s %f", itemsList.get(var).getPrice(), mark, itemsList.get(var+1).getPrice());
            Assert.assertTrue(itemsList.get(var).getPrice() <= itemsList.get(var+1).getPrice());
            var++;
        }
    }

    @When("User press add to cart button from item {int}")
    public void addtoCart(Integer itemNum) {
//        System.out.println("ADDING ITEM " + itemNum + " TO CART");
        inventoryPage.addItems(itemNum);
    }

    @Then("Product added to cart")
    public void checkCart() {
        inventoryPage.getCartNumber();
    }

    @And("User click Cart Button")
    public void clickCart() {
        inventoryPage.checkOut();
    }
}
