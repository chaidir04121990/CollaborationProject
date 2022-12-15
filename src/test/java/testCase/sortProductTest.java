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

public class sortProductTest {
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
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test (priority = 1, dataProvider = "successfulCredential", testName = "Challenge No 4C")
    public void sortPriceDesc (String username, String password) {
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

        // Sort Product & Validation
        homePage.sortPriceDesc();
    }

    @Test (priority = 2, dataProvider = "successfulCredential")
    public void sortPriceAsc (String username, String password) {
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

        // Sort Product & Validation
        homePage.sortPriceAsc();
    }

    @Test (priority = 3, dataProvider = "successfulCredential")
    public void sortNameDesc (String username, String password) {
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

        // Sort Product & Validation
        homePage.sortNameDesc();
    }

    @Test (priority = 4, dataProvider = "successfulCredential")
    public void sortNameAsc (String username, String password) {
        // Define Constructor
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        // Verify URL
        loginPage.goToLoginPage();
        loginPage.pageValidation();

        // Login Process
        loginPage.pageValidation();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        // Sort Product & Validation
        homePage.sortNameAsc();
    }
}
