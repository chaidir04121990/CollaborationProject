package TestNG_RA;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Nizam_TestNG {
    public static WebDriver driver;
    String url="https://www.tokopedia.com/";

    @Test
    public void ACPortable(){
        Actions actions = new Actions(driver);
        WebElement kategory = driver.findElement(By.xpath("//div[@data-testid=\"btnHeaderCategory\"]"));
        kategory.isDisplayed();
        actions.moveToElement(kategory).perform();
        WebElement elektronik = driver.findElement(By.xpath("//div[@data-testid=\"allCategories\"]/a[@data-testid=\"showHide#4\"]"));
        elektronik.isDisplayed();
        actions.moveToElement(elektronik).perform();
        WebElement acPortable = driver.findElement(By.xpath("//a[@data-testid=\"categoryNavigation#1\"]"));
        acPortable.isDisplayed();
        acPortable.click();
        WebElement validation = driver.findElement(By.xpath("//div[@class=\"css-198s1ee\"]"));
        validation.isDisplayed();


    }

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
