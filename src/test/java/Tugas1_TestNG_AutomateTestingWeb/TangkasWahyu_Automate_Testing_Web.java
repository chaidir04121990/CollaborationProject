package Tugas1_TestNG_AutomateTestingWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TangkasWahyu_Automate_Testing_Web {
    public static WebDriver driver;
    String baseUrl = "http://www.google.com";

    @BeforeMethod
    public void setup() {
        System.out.println("****Browser is Launching****");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test()
    public void Search_something() {
        WebElement Search_Field = driver.findElement(xpath("//input[@name=\"q\"]"));
        Search_Field.isDisplayed();
        Search_Field.sendKeys("Amazon");
        Search_Field.sendKeys(Keys.ENTER);
        WebElement Amazon = driver.findElement(xpath("//div[@class=\"tF2Cxc\"]/div/a/h3"));
        Amazon.click();
        WebElement Search_Validation = driver.findElement(xpath("//input[@name=\"field-keywords\"]"));
        Search_Validation.isDisplayed();
        Search_Validation.sendKeys("laptop");
        Search_Validation.sendKeys(Keys.ENTER);
        WebElement title = driver.findElement(xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/span/div/div/div/div/div/div[1]/div/div/span"));
        Assert.assertEquals((String) title.getText(),"FIND YOUR LAPTOP");

//        String t = "Find YOUR LAPTOP";
//
//        if(driver.getPageSource().contains(""))
//        {
//            System.out.println("Text " + t + " Found");
//        }
//        else
//        {
//            System.out.println("Text " + t + " Not Found");
//        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
