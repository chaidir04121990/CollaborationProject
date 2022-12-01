import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Nizam_TestNG {
    public static WebDriver driver;
    String url="https://magento.softwaretestingboard.com/";

    @Test
    public void addToCart(){
        Actions actions = new Actions(driver);
        WebElement Men = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[2]"));
        Men.isDisplayed();
        actions.moveToElement(Men).perform();
        WebElement Top = driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]/span[2]"));
        Top.isDisplayed();
        actions.moveToElement(Top).perform();
        WebElement jacket = driver.findElement(By.xpath("//*[@id=\"ui-id-19\"]/span"));
        jacket.isDisplayed();
        jacket.click();
        WebElement secondDisplay = driver.findElement(By.xpath("//ol[@class=\"products list items product-items\"]/li[2]"));
        secondDisplay.isDisplayed();
        secondDisplay.click();
        WebElement size = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
        size.isDisplayed();
        size.click();
        WebElement colour = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]"));
        colour.isDisplayed();
        colour.click();
        WebElement button = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        button.isDisplayed();
        button.click();
        String alert = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(alert,"You added Montana Wind Jacket to your shopping cart.");


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
