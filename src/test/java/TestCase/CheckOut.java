package TestCase;

import Page.CartPage;
import Page.HomePage;
import Page.InformationPage;
import Page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOut {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
    @Test
    public void checkOut2Items(){
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        CartPage cp = new CartPage(driver);
        InformationPage ip = new InformationPage(driver);

        lp.goToLoginPage();
        lp.inputUsername("standard_user");
        lp.inputPassword("secret_sauce");
        lp.clickButtonLogin();

        hp.addTwoItem();
        hp.validateCart();
        hp.move2CartPage();

        cp.validateCartPage();
        cp.checkOut();

        ip.ValidatePage();
        ip.firstname("coba");
        ip.lastname("coba");
        ip.zipCode("12345");
        ip.gotoContinuePage();
        ip.validationOverviewPage();
        ip.finishButton();
        ip.validateFinishOrder();
    }
}
