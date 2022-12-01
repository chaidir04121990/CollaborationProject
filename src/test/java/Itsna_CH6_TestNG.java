import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Itsna_CH6_TestNG {
        public static WebDriver driver;
        String url = "https://www.demoblaze.com";

        @BeforeTest
        public void setup() {
                System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
                driver.get(url);
        }

        @Test
        public void main() {
                String titleWeb = driver.getTitle();
                Assert.assertEquals(titleWeb, "STORE");
                WebElement pageTitle = driver.findElement(By.xpath("//nav/a"));
                String a = pageTitle.getText();
                Assert.assertEquals(a, "PRODUCT STORE");
                WebElement logo = driver.findElement(By.xpath("//nav/a/img"));
                logo.isDisplayed();
                WebElement homeMenu = driver.findElement(By.xpath("//nav/div[@class=\"navbar-collapse\"]/ul/li/a[text()=\"Home \"]"));
                homeMenu.isDisplayed();
                WebElement contactMenu = driver.findElement(By.xpath("//nav/div[@class=\"navbar-collapse\"]/ul/li/a[text()=\"Contact\"]"));
                contactMenu.isDisplayed();
                WebElement cartMenu = driver.findElement(By.xpath("//nav/div[@class=\"navbar-collapse\"]/ul/li/a[text()=\"Cart\"]"));
                cartMenu.isDisplayed();
                WebElement loginMenu = driver.findElement(By.xpath("//nav/div[@class=\"navbar-collapse\"]/ul/li/a[text()=\"Log in\"]"));
                loginMenu.isDisplayed();
                WebElement signupMenu = driver.findElement(By.xpath("//nav/div[@class=\"navbar-collapse\"]/ul/li/a[text()=\"Sign up\"]"));
                signupMenu.isDisplayed();
                WebElement flyer = driver.findElement(By.xpath("//nav/div[@id=\"contcar\"]"));
                flyer.isDisplayed();
                loginMenu.click();
                WebElement modalLogin = driver.findElement(By.xpath("//div[@class=\"modal-content\"]/div/h5[@id=\"logInModalLabel\"]"));
                modalLogin.isDisplayed();
                WebElement emailField = driver.findElement(By.xpath("//div[@class=\"modal-content\"]/div/form/div/input[@id=\"loginusername\"]"));
                emailField.isDisplayed();
                emailField.sendKeys("itsna");
                WebElement passField = driver.findElement(By.xpath("//div[@class=\"modal-content\"]/div/form/div/input[@id=\"loginpassword\"]"));
                passField.isDisplayed();
                passField.sendKeys("password");
                WebElement loginBtn = driver.findElement(By.xpath("//div[@class=\"modal-content\"]/div/button[@type=\"button\" and text()=\"Log in\"]"));
                loginBtn.isDisplayed();
                loginBtn.click();
                WebElement welcome = driver.findElement(By.xpath("//li/a[@id=\"nameofuser\" and text()=\"Welcome itsna\"]"));
                welcome.isDisplayed();
                String userActive = welcome.getText();
                Assert.assertEquals(userActive, "Welcome itsna");
        }

        @AfterTest
        public void teardown() {
                driver.close();
                driver.quit();
        }
}