package TestCase;

import Page.HomePage;
import Page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void sortPriceHigh2Low(){
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);

        lp.goToLoginPage();
        lp.inputUsername("standard_user");
        lp.inputPassword("secret_sauce");
        lp.clickButtonLogin();

        hp.clickSortButton();
        hp.sortpriceHtl();
        hp.validatepriceHtL();
    }
}
