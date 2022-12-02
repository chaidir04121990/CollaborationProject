package TestNG_RA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test_Shopee {
    public static WebDriver driver;
    String baseURL = "https://shopee.co.id/";

    @Test
    public void Beli_pulsa(){
        WebElement buyPulsaButton = driver.findElement(By.xpath("//div[@class=\"xZ4bbg\"]/a[3]"));
        buyPulsaButton.isDisplayed();
        buyPulsaButton.click();

        //validasi change page
        WebElement buyPulsaPage = driver.findElement(By.xpath("//h1[@class=\"_128L6xFvUO1W8xPTwIBmTP\"]"));
        buyPulsaPage.isDisplayed();

        WebElement pulsaCategory = driver.findElement(By.xpath("//div[@class=\"ONCmZc2coGxOraJFd4_Yj eNaU3hoIkzVSW8hrQPmym\"]/div[1]"));
        pulsaCategory.isDisplayed();
        pulsaCategory.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@type=\"tel\"]"));
        phoneNumber.isDisplayed();
        phoneNumber.sendKeys("085866982310");

        WebElement buyButton = driver.findElement(By.xpath("//button[@class=\"_3EkP5c3BnXJ6A0HWlPqdDC _3xwQObcikm7PYl2kcITfoi\"]"));
        buyButton.isDisplayed();
        buyButton.click();

        //validasi change page
        WebElement loginPage = driver.findElement(By.xpath("//div[@class=\"u9tve2\"]"));
        loginPage.isDisplayed();
    }

    @BeforeMethod
    public void setup(){
        System.out.println("==========Browser is launching==========");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
