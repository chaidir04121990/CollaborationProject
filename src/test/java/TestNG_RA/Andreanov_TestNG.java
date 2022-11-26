package TestNG_RA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Andreanov_TestNG {
    WebDriver driver = null;

    @BeforeMethod
    public void setup (){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Downloads\\Compressed\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void search () {
        driver.get("https://id.wikipedia.org/wiki/Halaman_Utama");
        String a = "automation";
        WebElement r = driver.findElement(By.name("search"));
        r.sendKeys(a);
        r.sendKeys(Keys.RETURN);

        // Validation
        String expectedTitle = "Hasil pencarian \""+a+"\" - Wikipedia bahasa Indonesia, ensiklopedia bebas";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
