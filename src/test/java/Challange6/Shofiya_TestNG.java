package Challange6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
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
    public void search(){
        driver.get("https://www.joox.com/id");
        WebElement search_field = driver.findElement(By.xpath("//input[@class=\"jsx-436437380 jsx-2210511138 inputSearch\"]"));
        search_field.isDisplayed();
        search_field.sendKeys("Tulus");
        search_field.sendKeys(Keys.ENTER);
        WebElement button_playlist = driver.findElement(By.xpath("//button[@class=\"jsx-202257454 active tabListItems\"]"));
        button_playlist.isDisplayed();
        button_playlist.click();
        WebElement top_playlist = driver.findElement(By.xpath("//a[@class=\"jsx-3051754664\"]"));
        top_playlist.isDisplayed();
        top_playlist.click();
        WebElement playlist_title = driver.findElement(By.xpath("//h1[@class=\"jsx-215821495 title\"][text()=\"Best of Tulus\"]"));
        playlist_title.isDisplayed();
        String title = playlist_title.getText();
        Assert.assertEquals(title, "Best of Tulus");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

