package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginTest {

    public WebDriver driverPage;
    setupAll setupParam;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        System.out.println("LOGIN BEFORE TEST...");
        setupParam = new setupAll(browser);
        setupParam.setUrl("https://www.saucedemo.com/");
        this.driverPage = setupParam.getDriver();
    }

    @Test
    public void loginFailed(){
        System.out.println("Login Failed Wrong Username");
        setupParam.loginTesting(driverPage,"standard_user", "not_secret_sauce");

        Assert.assertEquals(driverPage.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginSuccess(){
        System.out.println("Login Success");

        setupParam.loginTesting(driverPage,"standard_user", "secret_sauce");
        driverPage.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(driverPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @AfterMethod
    public void teardown(){
        System.out.println("LOGIN AFTER TEST...");
//        this.driverPage.quit();
        this.setupParam.tearDown();
    }

}
