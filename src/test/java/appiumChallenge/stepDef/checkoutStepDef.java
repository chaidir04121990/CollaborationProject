package appiumChallenge.stepDef;

import appiumChallenge.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.util.Objects;

public class checkoutStepDef {

    public cartPageFactory cartPage;
    public checkoutFirstPageFactory checkoutFirst;
    public checkoutSecondPageFactory checkoutSecond;
    public checkoutCompletePageFactory checkoutComplete;

    public String pageName;
    @And("User is on {string} page")
    public void onPage(String pageNavBar) {
        if (pageNavBar.toUpperCase().equals("YOUR CART")){
            this.cartPage = new cartPageFactory();
            this.pageName = pageNavBar;
            Assert.assertEquals(cartPage.checkPageNavBar(), pageNavBar);
        }
        if (pageNavBar.toUpperCase().equals("CHECKOUT: INFORMATION")){
            this.checkoutFirst = new checkoutFirstPageFactory();
            this.pageName = pageNavBar;
            Assert.assertEquals(checkoutFirst.checkPageNavBar(), pageNavBar);
        }
        else if (pageNavBar.toUpperCase().equals("CHECKOUT: OVERVIEW")){
            this.checkoutSecond = new checkoutSecondPageFactory();
            this.pageName = pageNavBar;
            Assert.assertEquals(checkoutSecond.checkPageNavBar(), pageNavBar);
        }
        else if (pageNavBar.toUpperCase().equals("CHECKOUT: COMPLETE!")){
            this.checkoutComplete = new checkoutCompletePageFactory();
            this.pageName = pageNavBar;
            checkoutCompleteMessage finishObj = checkoutComplete.checkPageNavBar();
            Assert.assertEquals(finishObj.pageNavText, pageNavBar);
            Assert.assertEquals(finishObj.message1, "THANK YOU FOR YOU ORDER");
            Assert.assertEquals(finishObj.message2, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
            Assert.assertTrue(finishObj.imageMessage.isDisplayed());
        }
    }

    @And("User input {string} field with {string}")
    public void inputField(String fieldName, String inputData) {
        switch (fieldName.toUpperCase()) {
            case "FIRST NAME" -> checkoutFirst.setFirstName(inputData);
            case "LAST NAME" -> checkoutFirst.setLastName(inputData);
            case "ZIP CODE" -> checkoutFirst.setZipCode(inputData);
        }

    }

    @And("User click on {string} Button")
    public void checkCart(String buttonName) {

//        System.out.println(buttonName);
        if (buttonName.toUpperCase().equals("CHECKOUT")) { cartPage.pressCheckoutButton(); }
        else if (buttonName.toUpperCase().equals("CONTINUE")) { checkoutFirst.continueCheckout(); }
        else if (buttonName.toUpperCase().equals("FINISH")) { checkoutSecond.finishCheckout(); }
    }

}
