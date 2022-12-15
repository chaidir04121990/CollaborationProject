package Test;

import Page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

public class DemoSeleniumBasic {
    WebDriver driver;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeMethod
    public void test_simple_selenium(){
        System.out.println("==========Browser is launching==========");
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    @Test (priority = 1)
    public void launchingWeb(){
        assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test (priority = 2)
    public void loginTrue() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test (priority = 3)
    public void loginLockedAccount() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("locked_out_user");
        login.inputPassword("secret_sauce");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
    }

    @Test (priority = 4)
    public void loginFalse() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("locked_out_user");
        login.inputPassword("wrong_password");
        login.buttonLogin();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        expectedEx.expectMessage("Username and password do not match any user in this service");
    }

    @Test (priority = 5)
    public void descendantPriceSort() throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.buttonLogin();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")), driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        Thread.sleep(3000);
    }


    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
