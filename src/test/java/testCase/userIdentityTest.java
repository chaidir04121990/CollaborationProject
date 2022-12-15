package testCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;

public class userIdentityTest {
    WebDriver driver = null;

    @BeforeTest
    @Parameters("browser")
    public void setup (String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkFirstnameIsMandatory () {
        loginPage loginPage = new loginPage(driver);
        headerPage headerPage = new headerPage(driver);
        homePage homePage = new homePage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.setAddToCartButton();

        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname("");
        checkoutUserIdentityPage.inputLastname("Ridhovan");
        checkoutUserIdentityPage.inputPostalCode("123456");
        checkoutUserIdentityPage.continueButton();
        checkoutUserIdentityPage.checkFirstnameIsMandatory();

        // Remove Product
        checkoutUserIdentityPage.cancelButton();
        shoppingCartPage.removeButton();
    }

    @Test(priority = 2)
    public void checkLastnameIsMandatory () {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);
        headerPage headerPage = new headerPage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.setAddToCartButton();

        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname("Andreanov");
        checkoutUserIdentityPage.inputLastname("");
        checkoutUserIdentityPage.inputPostalCode("123456");
        checkoutUserIdentityPage.continueButton();
        checkoutUserIdentityPage.checkLastnameIsMandatory();

        // Remove Product
        checkoutUserIdentityPage.cancelButton();
        shoppingCartPage.removeButton();
    }

    @Test(priority = 3)
    public void checkPostalCodeIsMandatory () {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);
        headerPage headerPage = new headerPage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.setAddToCartButton();

        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname("Andreanov");
        checkoutUserIdentityPage.inputLastname("Ridhovan");
        checkoutUserIdentityPage.inputPostalCode("");
        checkoutUserIdentityPage.continueButton();
        checkoutUserIdentityPage.checkPostalCodeIsMandatory();

        // Remove Product
        checkoutUserIdentityPage.cancelButton();
        shoppingCartPage.removeButton();
    }

    @Test(priority = 4)
    public void checkAllFieldIsMandatory () {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);
        headerPage headerPage = new headerPage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.setAddToCartButton();

        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname("");
        checkoutUserIdentityPage.inputLastname("");
        checkoutUserIdentityPage.inputPostalCode("");
        checkoutUserIdentityPage.continueButton();
        checkoutUserIdentityPage.checkAllFieldIsMandatory();

        // Remove Product
        checkoutUserIdentityPage.cancelButton();
        shoppingCartPage.removeButton();
    }
}
