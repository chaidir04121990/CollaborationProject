import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class config {

    public String url = "https://reqres.in/";
    public String serverValue = "cloudflare";
    public String contentTypeValue = "application/json";
    public Integer waitTime = 2000;
    public String pathXPath = "//*[@id=\"console\"]/div[2]/div[1]/p/strong/a/span";
    public String statusCodeXPath = "//*[@id=\"console\"]/div[2]/div[2]/p/strong/span";
    public String bodyRequestXPath = "//*[@id=\"console\"]/div[2]/div[1]/pre";
    public String methodButtonXPath = "//*[@id=\"console\"]/div[1]/ul/li";
    WebDriver driver =null;

    @BeforeMethod
    public void setup (){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Downloads\\Compressed\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        RestAssured.baseURI= url;
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
