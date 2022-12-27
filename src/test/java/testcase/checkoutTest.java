package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.*;

import java.util.List;

public class checkoutTest {

    WebDriver driverPage;
    setupAll setupParam;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        System.out.println("SORTING BEFORE TEST...");
        setupParam = new setupAll(browser);
        setupParam.setUrl("https://www.saucedemo.com/");
        driverPage = setupParam.getDriver();
    }

    @Test
    @Parameters("mode")
    public void checkoutTest(String mode){

        System.out.println("Checkout Test");

        inventoryPageFactory inventoryPage = new inventoryPageFactory(driverPage);
        cartPageFactory cartPage = new cartPageFactory(driverPage);
        stepOnePageFactory stepOne = new stepOnePageFactory(driverPage);
        stepTwoPageFactory stepTwo = new stepTwoPageFactory(driverPage);
        completePage compPage = new completePage(driverPage);

        setupParam.loginTesting(driverPage,"standard_user", "secret_sauce");

        int amount = 3;

        sortingTest.InventoryPriceComparison(driverPage, mode);

        inventoryPage.addItems(amount);
        inventoryPage.checkOut();
        cartPage.removeItem(99);
        Assert.assertEquals(cartPage.countItems(), amount);
        cartPage.continueCheckout();

        stepOne.inputForm("firstName", "John");
        stepOne.inputForm("lastName", "Doe");
        stepOne.inputForm("postalCode", "60111");
        stepOne.continueStep();

        stepTwo.finishStep();

        Assert.assertEquals(compPage.finishtext1(),"THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(compPage.finishtext2(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @AfterMethod
    public void teardown(){
        System.out.println("SORTING AFTER TEST...");
//        System.out.println(driverPage);
        this.setupParam.tearDown();
    }

}
