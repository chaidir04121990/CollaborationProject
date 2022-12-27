package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.inventoryPageFactory;

import java.time.Duration;
import java.util.List;

public class sortingTest {

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

    public static void InventoryPriceComparison(WebDriver driverPPP, String mode){
        System.out.println("Iventory Comparison with " + mode + " mode");

        inventoryPageFactory inventoryPage = new inventoryPageFactory(driverPPP);

        inventoryPage.sorting(mode);
        List<Double> itemList = inventoryPage.getItemsPrice();

        int var = 0;
        while (var < itemList.size()-1){
            System.out.println(itemList.get(var).toString() + " >= " + itemList.get(var+1));
            Assert.assertTrue(itemList.get(var) >= itemList.get(var+1));
            var++;
        }

    }

    @Test
    @Parameters("mode")
    public void comparePriceTest(String mode){
        setupParam.loginTesting(driverPage, "standard_user", "secret_sauce");
        InventoryPriceComparison(driverPage, mode);
    }

    @AfterMethod
    public void teardown(){
        System.out.println("SORTING AFTER TEST...");
//        System.out.println(driverPage);
        this.setupParam.tearDown();
    }

}
