package testCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import page.*;

import java.time.Duration;

public class BookingTest {

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

    @DataProvider(name = "successfulCredential")
    public static Object[][] successfulCredential() {
        return new Object[][] {
                {"performance_glitch_user", "secret_sauce", "Andreanov", "Ridhovan", "12345"},
                {"standard_user", "secret_sauce", "Andreanov", "Ridhovan", "12345"}
        };
    }

    @Test(priority = 1, dataProvider = "successfulCredential", testName = "Challenge No 4D")
    public void bookingSuccessfulViaHomepage (String username, String password, String firstname, String lastname, String postalCode) {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);
        headerPage headerPage = new headerPage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);
        checkoutSummaryPage checkoutSummaryPage = new checkoutSummaryPage(driver);
        transactionSuccessfulPage transactionSuccessfulPage = new transactionSuccessfulPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.setAddToCartButton();
        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname(firstname);
        checkoutUserIdentityPage.inputLastname(lastname);
        checkoutUserIdentityPage.inputPostalCode(postalCode);
        checkoutUserIdentityPage.continueButton();

        checkoutSummaryPage.pageValidation();
        checkoutSummaryPage.verifyCalculation();
        checkoutSummaryPage.finishButton();

        transactionSuccessfulPage.pageValidation();
    }

    @Test(priority = 2, dataProvider = "successfulCredential")
    public void bookingSuccessfulViaProductDetailPage (String username, String password, String firstname, String lastname, String postalCode) {
        loginPage loginPage = new loginPage(driver);
        headerPage headerPage = new headerPage(driver);
        productDetailPage productDetailPage = new productDetailPage(driver);
        homePage homePage = new homePage(driver);
        shoppingCartPage shoppingCartPage = new shoppingCartPage(driver);
        checkoutUserIdentityPage checkoutUserIdentityPage = new checkoutUserIdentityPage(driver);
        checkoutSummaryPage checkoutSummaryPage = new checkoutSummaryPage(driver);
        transactionSuccessfulPage transactionSuccessfulPage = new transactionSuccessfulPage(driver);

        loginPage.goToLoginPage();
        loginPage.pageValidation();

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        homePage.checkProductList();
        homePage.viewProduct1();

        productDetailPage.pageValidation();
        productDetailPage.addProductToCartButton();
        headerPage.cartButton();

        shoppingCartPage.pageValidation();
        shoppingCartPage.verifyTotalProductInCart();;
        shoppingCartPage.checkoutButton();

        checkoutUserIdentityPage.pageValidation();
        checkoutUserIdentityPage.inputFirstname(firstname);
        checkoutUserIdentityPage.inputLastname(lastname);
        checkoutUserIdentityPage.inputPostalCode(postalCode);
        checkoutUserIdentityPage.continueButton();

        checkoutSummaryPage.pageValidation();
        checkoutSummaryPage.verifyCalculation();
        checkoutSummaryPage.finishButton();

        transactionSuccessfulPage.pageValidation();
    }
}
