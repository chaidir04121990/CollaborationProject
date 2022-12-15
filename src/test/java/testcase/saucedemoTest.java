package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.loginPage;
import page.cartPage;
import page.checkoutCompletePage;
import page.checkoutPageOne;
import page.checkoutPageTwo;
import page.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class saucedemoTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    // login success
    @Test(priority = 1)
    public void loginSuccess() {
        loginPage lp = new loginPage(driver);
        homePage hp = new homePage(driver);

        lp.goToLoginPage();
        lp.inputUsername("standard_user");
        lp.inputPassword("secret_sauce");
        lp.clickLoginButton();
        hp.onHomePage();
    }

    // sorting items from higher to lower price
    @Test(priority = 2)
    public void sorting() {
        homePage hp = new homePage(driver);

        hp.onHomePage();
        hp.sortHighToLowPrice();
    }

    // adding items to cart
    @Test(priority = 3)
    public void addToCart() {
        homePage hp = new homePage(driver);

        hp.addItem(2);
    }

    // adding to cart, input personal data, and checkout
    @Test(priority = 4)
    public void checkout() {
        homePage hp = new homePage(driver);
        cartPage cp = new cartPage(driver);
        checkoutPageOne cpOne = new checkoutPageOne(driver);
        checkoutPageTwo cpTwo = new checkoutPageTwo(driver);
        checkoutCompletePage cpComplete = new checkoutCompletePage(driver);

        hp.goToCartPage();

        // direct to cart page
        cp.onCartPage();
        cp.clickCheckoutBtn();

        // direct to checkout page one
        cpOne.onCheckoutPageOne();
        cpOne.inputFirstName("Slamet");
        cpOne.inputLastName("Raharjo");
        cpOne.inputPostalCode("569901");
        cpOne.clickContinueBtn();

        // direct to checkout page two
        cpTwo.onCheckoutPageTwo();
        cpTwo.clickFinishBtn();

        // direct to checkout complete page
        cpComplete.onCheckoutCompletePage();
    }

    // failed login test case
    @Test(priority = 5)
    public void loginFailed() {
        loginPage lp = new loginPage(driver);

        lp.goToLoginPage();
        lp.inputUsername("standard_user");
        lp.inputPassword("wrong_password");
        lp.clickLoginButton();
        lp.errorPasswordMsgShow();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
