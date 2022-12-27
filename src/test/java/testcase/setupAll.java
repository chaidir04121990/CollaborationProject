package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;
import page.*;

import java.util.concurrent.TimeUnit;

public class setupAll {

    WebDriver driver;
    String url;

    public setupAll(String browser){

        url = "https://www.google.com/";

        if (browser.toLowerCase().equals("firefox")){
            System.out.println(browser.toUpperCase());
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        if (browser.toLowerCase().equals("chrome")){
            System.out.println(browser.toUpperCase());
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        if (browser.toLowerCase().equals("edge")){
            System.out.println(browser.toUpperCase());
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
    }

    public void setUrl(String url){
        this.url = url;
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void tearDown(){
        driver.quit();
    }

    public void loginTesting(WebDriver driver, String username, String password){
        loginPageFactory login = new loginPageFactory(driver);

        login.inputUsername(username);
        login.inputPassword(password);

        login.clickLoginButton();
    }

}
