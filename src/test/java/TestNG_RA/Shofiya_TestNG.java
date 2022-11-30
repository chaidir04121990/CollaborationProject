package TestNG_RA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Shofiya_TestNG {
    public static WebDriver driver;
    String baseURL = "https://www.google.com/";

    @Test
    public void search(){
        // WebElement Search_Field = driver.findElement(By.xpath("//input[@"));
        WebElement Search_Field = driver.findElement(By.name("q"));
        Search_Field.isDisplayed();
        Search_Field.sendKeys("Test Automation");

        WebElement Search_validation = driver.findElement(By.xpath("//div[@class=\"a4bIc\"]/input[@value=\"Test Automation\"]"));
        Search_validation.isDisplayed();
    }

    @BeforeMethod
    public void setup(){
        System.out.println("===Browser is Launching===");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

