package testcase;

import org.testng.annotations.AfterMethod;
import page.loginPage;
import page.productPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void loginSuccess() {
        loginPage loginPage = new loginPage(driver);
        productPage productPage = new productPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void loginFailed() {
        loginPage loginPage = new loginPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("wrong_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.errorUsernameMsgShow();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}