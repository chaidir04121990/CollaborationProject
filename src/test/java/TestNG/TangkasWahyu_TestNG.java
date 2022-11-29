package Testing_tesNG_Kamis.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TangkasWahyu_TestNG {
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
//        @FindBy(xpath("//input[@name=\"q\"]"))
//        WebElement Search_Field = driver.findElement(By.name("q"));
        // cara mengecek inspect //input[@name=\"q\"]

        WebElement Search_Field = driver.findElement(xpath("//input[@name=\"q\"]"));
        Search_Field.isDisplayed();
        Search_Field.sendKeys("Amazon");
        Search_Field.sendKeys(Keys.ENTER);

        WebElement Amazon = driver.findElement(xpath("//div[@class=\"tF2Cxc\"]/div/a/h3"));
        Amazon.click();

//        // Validate Logo Amazon
//        WebElement Search_Validation = driver.findElement(By.xpath("//header[@id=\"navbar-main\"]/div/div/div/div/a[@id=\"nav-logo-sprites\"]"));
//        Search_Validation.isDisplayed();

        // Validate Search Laptop In Amazon
        WebElement Search_Validation = driver.findElement(By.xpath("//input[@name=\"field-keywords\"]"));
        Search_Validation.isDisplayed();
        Search_Validation.sendKeys("laptop");
        Search_Validation.sendKeys(Keys.ENTER);

        String t = "Find YOUR LAPTOP";

        if(driver.getPageSource().contains(""))
        {
            System.out.println("Text " + t + "Found");
        }
        else
        {
            System.out.println("Text " + t + "Not Found");
        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
