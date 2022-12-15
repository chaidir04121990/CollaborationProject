package TestCase;

import Page.loginPage;
import Page.productPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortingTest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void sortDescending(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginPage loginPage = new loginPage(driver);
        productPage productPage = new productPage(driver);

        loginPage.goToLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Get List of Price before Sorting
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));

        List <Double> beforeFilterPriceList = new ArrayList<>();

        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        productPage.clickSortButton();
        productPage.clickSortOption();

        //Get List of Price after Sorting
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));

        List <Double> afterFilterPriceList = new ArrayList<>();

        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Collections.sort(beforeFilterPriceList); //List sorted ascending
        Collections.reverse(beforeFilterPriceList); //List sorted descending
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}