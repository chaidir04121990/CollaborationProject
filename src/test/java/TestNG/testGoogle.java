package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class testGoogle {
    public static WebDriver driver;
    String baseURL = "https://www.worldhistory.org/";

    @Test
    public void searchSomething(){
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.isDisplayed();
        searchField.sendKeys("Persian");
        searchField.sendKeys(Keys.ENTER);

        WebElement validationField = driver.findElement(By.xpath("//div[@class=\"search_wrapper\"]/input[@value=\"Persian\"]"));
        validationField.isDisplayed();
    }


    @BeforeMethod
    public void setup(){
        System.out.println("========Browser is Launching======");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}