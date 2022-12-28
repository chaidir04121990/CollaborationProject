package Test;

import Page.*;
//import Page.CheckoutPage;
//import Page.Homepage;
//import Page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

public class DemoSeleniumBasic {
    WebDriver driver;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeMethod
    public void test_simple_selenium(){
        System.out.println("==========Browser is launching==========");
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    @Test (priority = 1)
    public void launchingWeb(){
        assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test (priority = 2)
    public void loginTrue() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test (priority = 3)
    public void loginLockedAccount() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("locked_out_user");
        login.inputPassword("secret_sauce");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
    }

    @Test (priority = 4)
    public void loginFalse() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("locked_out_user");
        login.inputPassword("wrong_password");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        expectedEx.expectMessage("Username and password do not match any user in this service");
    }

    @Test (priority = 5)
    public void descendantPriceSort() throws InterruptedException{
        loginTrue();

        Homepage homepage = new Homepage(driver);
        homepage.sortContainer();
        homepage.descendantSort();
        Thread.sleep(2000);
        List<WebElement> elementList = driver.findElements(By.className("inventory_item_price"));
        Assert.assertTrue(Float.parseFloat(elementList.get(0).getText().substring(1)) >= Float.parseFloat(elementList.get(1).getText().substring(1)));
    }

    @Test (priority = 6)
    public void Checkout() throws InterruptedException {
        loginTrue();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.addToCart();
        assertEquals(driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).getText(), "REMOVE");
        assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(), "REMOVE");
        checkoutPage.Cart();
        assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        checkoutPage.checkoutClick();
        assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage.checkoutOne();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        checkoutPage.checkoutTwo();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        Thread.sleep(2000);

        //tinggal tambah assertionnya

    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
