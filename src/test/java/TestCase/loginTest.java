package TestCase;

import Page.loginPage;
import Page.productPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void loginSuccess() {
        loginPage loginPage = new loginPage(driver);
        productPage productPage = new productPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        productPage.validateLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void loginFailed() {
        loginPage loginPage = new loginPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("wrong_user");
        loginPage.inputPassword("wrong_password");
        loginPage.clickLoginButton();
        loginPage.validateError();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}