package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;
import page.LoginPage;
import page.HomePage;
import page.CheckoutPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 2)
    public void failedLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("wrong_username");
        loginPage.inputPassword("wrong_password");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void shortingTest(){
        HomePage homePage = new HomePage(driver);
        loginTest();

        homePage.clickShortHiLo();
        List<WebElement> elementList = driver.findElements(By.className("inventory_item_price"));
        Assert.assertTrue(Float.parseFloat(elementList.get(0).getText().substring(1)) >= Float.parseFloat(elementList.get(1).getText().substring(1)));
        Assert.assertTrue(Float.parseFloat(elementList.get(1).getText().substring(1)) >= Float.parseFloat(elementList.get(2).getText().substring(1)));
        Assert.assertTrue(Float.parseFloat(elementList.get(2).getText().substring(1)) >= Float.parseFloat(elementList.get(3).getText().substring(1)));
        Assert.assertTrue(Float.parseFloat(elementList.get(3).getText().substring(1)) >= Float.parseFloat(elementList.get(4).getText().substring(1)));
        Assert.assertTrue(Float.parseFloat(elementList.get(4).getText().substring(1)) >= Float.parseFloat(elementList.get(5).getText().substring(1)));
    }


    @Test(priority = 4)
    public void checkoutTest(){
        loginTest();
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickItem1();
        checkoutPage.clickItem2();
        checkoutPage.clickShoppingChart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        checkoutPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage.inputFirstName("shofiya");
        checkoutPage.inputLastName("khalisa");
        checkoutPage.inputPostalCode("1234");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        checkoutPage.clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText(),"THANK YOU FOR YOUR ORDER");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
