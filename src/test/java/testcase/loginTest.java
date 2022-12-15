package testcase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.ItemList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginTest {

    WebDriver driver;

    @BeforeMethod
//    @Test
    public void setup(){
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("headless");
        options.setHeadless(true);

        driver = new FirefoxDriver(options);

        String url ="https://www.saucedemo.com/";

//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        driver.get(url);
    }

    public void loginTesting(String username, String password){
//        loginPage login = new loginPage(driver);
        loginPageFactory login = new loginPageFactory(driver);

        login.inputUsername(username);
        login.inputPassword(password);

        login.clickLoginButton();
    }

    @Test(priority = 1)
    public void loginFailed_WrongPassword(){
        System.out.println("Login Failed Wrong Username");
        loginTesting("standard_user", "not_secret_sauce");

        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 2)
    public void loginSuccess(){

        System.out.println("Login Success");

        loginTesting("standard_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test(priority = 3)
    public void InventoryPriceComparison(){
        System.out.println("Iventory Comparison");

        loginTesting("standard_user", "secret_sauce");

        inventoryPageFactory inventoryPage = new inventoryPageFactory(driver);

        inventoryPage.sorting("hilo");
        List<Double> itemList = inventoryPage.getItemsPrice();

        int var = 0;
        while (var < itemList.size()-1){
//            System.out.println(itemList.get(var).toString() + "<=" + itemList.get(var+1));
            Assert.assertTrue(itemList.get(var) >= itemList.get(var+1));
            var++;
        }

    }

    @Test(priority = 4)
    public void checkoutTest(){

        System.out.println("Checkout Test");

        inventoryPageFactory inventoryPage = new inventoryPageFactory(driver);
        cartPageFactory cartPage = new cartPageFactory(driver);
        stepOnePageFactory stepOne = new stepOnePageFactory(driver);
        stepTwoPageFactory stepTwo = new stepTwoPageFactory(driver);
        completePage compPage = new completePage(driver);

        loginTesting("standard_user", "secret_sauce");

        int amount = 3;

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
        driver.quit();
    }

}
