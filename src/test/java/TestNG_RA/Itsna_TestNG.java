package TestNG_RA;

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

public class Itsna_TestNG {
    public static WebDriver driver;
    String url = "https://maps.google.com";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void dosmthng() {
        String titleWeb = driver.getTitle();
        Assert.assertEquals(titleWeb, "Google Maps");
        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"searchboxinput\"]"));
        field1.isDisplayed();
        field1.sendKeys("Privy Quarter");
        WebElement rute = driver.findElement(By.xpath("//*[@id=\"hArJGc\"]"));
        rute.isDisplayed();
        rute.click();
        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"sb_ifc50\"]/input"));
        field2.isDisplayed();
        field2.sendKeys("Privy Pass");
        field2.sendKeys(Keys.ENTER);
        WebElement arrow = driver.findElement(By.xpath("//*[@id=\"QA0Szd\"]/div/div/div[2]/button"));
        arrow.isDisplayed();
        arrow.click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Privy Pass ke PrivyID (Privy Quarter) - Google Maps");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}