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
import page.homePage;
import page.loginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest {
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
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "lockedUserCredential")
    public static Object[][] lockedUserCredential() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "unsuccessfulCredential")
    public static Object[][] unsuccessfulCredential() {
        return new Object[][] {
                {"test1", "secret_sauce"},
                {"problem_user", "test1"},
                {"test1", "test1"}
        };
    }

    @Test (priority = 1, dataProvider = "successfulCredential", testName = "Challenge No 4A")
    public void successfulLogin (String username, String password) {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        // Validation
        homePage.checkProductList();
    }

    @Test (priority = 2, dataProvider = "lockedUserCredential")
    public void lockedUserCredential (String username, String password) {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        // Validation
        loginPage.checkLockedAccount();
    }

    @Test (priority = 3, dataProvider = "unsuccessfulCredential", testName = "Challenge No 4B")
    public void failedLoginWithWrongPassword (String username, String password) {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        // Validation
        loginPage.checkPasswordNotMatch();
    }

    @Test (priority = 4)
    public void failedLoginWithEmptyUsername () {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Validation
        loginPage.checkUsernameIsMandatory();
    }

    @Test (priority = 5)
    public void failedLoginWithEmptyPassword () {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clickLoginButton();

        // Validation
        loginPage.checkPasswordIsMandatory();
    }

    @Test (priority = 6)
    public void failedLoginWithEmptyAllField () {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLoginButton();

        // Validation
        loginPage.checkAllFiedlIsMandatory();
    }
}
