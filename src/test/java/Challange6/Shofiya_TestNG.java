package Challange6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Shofiya_TestNG {
    public static WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("===Browser is Launching===");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void login(){
        driver.get("https://www.facebook.com/");
        WebElement email_field = driver.findElement(By.xpath("//div[@class=\"_6lux\"]/input[@class=\"inputtext _55r1 _6luy\"]"));
        email_field.isDisplayed();
        email_field.sendKeys("shofiya@gmail.com");
        WebElement password_field = driver.findElement(By.xpath("//div[@class=\"@class=\"_6luy _55r1 _1kbt _9nyh\"]"));
        password_field.isDisplayed();
        password_field.sendKeys("Coba1234");
        WebElement login_button = driver.findElement(By.xpath("//div[@class=\"@class=\"_6ltg\"]/button[@name=\"login\"]"));
        login_button.isDisplayed();
        login_button.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

