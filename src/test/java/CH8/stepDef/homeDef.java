package CH8.stepDef;

import CH8.baseTest;
import CH8.pages.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homeDef extends baseTest {
    homePage homepage = new homePage();

    @Then("user is on homepage")
    public void userIsOnHomePage() {
        homepage.validateOnPage();
    }

    @And("user add 1 product to the cart")
    public void addOneProductToTheCart() {
        homepage.addOneProduct();
    }

    @And("user add 2 products to the cart")
    public void addTwoProductsToTheCart() {
        homepage.addTwoProduct();
    }

    @And("user add 3 products to the cart")
    public void addThreeProductsToTheCart() {
        homepage.addThreeProduct();
    }

    @And("user add 4 products to the cart")
    public void addFourProductsToTheCart() {
        homepage.addFourProduct();
    }

    @And("user add 5 products to the cart")
    public void addFiveProductsToTheCart() {
        homepage.addFiveProduct();
    }

    @And("user add 6 products to the cart")
    public void addSixProductsToTheCart() {
        homepage.addSixProduct();
    }

    @And("user click on cart button")
    public void clickCartButton() {
        homepage.clickCartButton();
    }

    @And("user click sort button")
    public void clicksortButton() {
        homepage.clickSortButton();
    }

    @When("user click sort price low to high button")
    public void clickLohiPriceButton() {
        homepage.clickLohiButton();
    }

    @When("user click sort price high to low button")
    public void clickHiloPriceButton() {
        homepage.clickHiloButton();
    }

    @When("user click sort price A to Z button")
    public void clickAscAlphabetButton() {
        homepage.clickAscAlphabetButton();
    }

    @When("user click sort price Z to A button")
    public void clickDescAlphabetButton() {
        homepage.clickDescAlphabetButton();
    }

    @Then("user see list product from lowest price")
    public void userSeeProductFromLowestPrice() {
        homepage.validateOnPage();
        homepage.validationSortLowToHiPrice();
    }

    @Then("user see list product from highest price")
    public void userSeeProductFromHighestPrice() {
        homepage.validateOnPage();
        homepage.validationSortHiToLowPrice();
    }

    @Then("user see list product alphabet asc")
    public void userSeeProductFromAscAlphabet() {
        homepage.validateOnPage();
        homepage.validationSortAToZ();
    }

    @Then("user see list product alphabet desc")
    public void userSeeProductFromDescAlphabet() {
        homepage.validateOnPage();
        homepage.validationSortZToA();
    }
}