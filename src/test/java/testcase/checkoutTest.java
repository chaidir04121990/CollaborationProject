package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;

public class checkoutTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @Test(priority = 4)
    public void checkout() {
        loginPage lp = new loginPage(driver);
        homePage hp = new homePage(driver);
        cartPage cp = new cartPage(driver);
        checkoutPageOne cpOne = new checkoutPageOne(driver);
        checkoutPageTwo cpTwo = new checkoutPageTwo(driver);
        checkoutCompletePage cpComplete = new checkoutCompletePage(driver);

        //login
        lp.goToLoginPage();
        lp.inputUsername("standard_user");
        lp.inputPassword("secret_sauce");
        lp.clickLoginButton();
        hp.onHomePage();

        //sorting
        hp.onHomePage();
        hp.sortHighToLowPrice();
        
        //click cart button
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
}
