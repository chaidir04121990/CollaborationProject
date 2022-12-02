package Tiara_CH6;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Tokopedia {

    public static WebDriver driver;

    String baseURL = "https://www.tokopedia.com/";

//    @Test
//    public void Search_item(){
//        WebElement searchItem = driver.findElement(By.xpath("//div[@class = \"css-4txsjy e1v32nag0\"]/input"));
//        searchItem.isDisplayed();
//        searchItem.sendKeys("jam tangan");
//        searchItem.sendKeys(Keys.ENTER);
//
//        //validasi change page
//        WebElement itemList = driver.findElement(By.xpath("//div[@class = \"css-1yus67o\"]/button[1]"));
//        itemList.isDisplayed();
//    }

    @Test
    public void Train_ticket(){
        WebElement travelEnt = driver.findElement(By.xpath("//div[@class=\"css-1995st\"]/a[4]"));
        travelEnt.isDisplayed();
        travelEnt.click();

        WebElement trainTicket = driver.findElement(By.xpath("//div[@class=\"c_items\"]/a[2]"));
        trainTicket.isDisplayed();
        trainTicket.click();

        //Memilih asal
        WebElement origin = driver.findElement(By.xpath("//div[@class=\"location\"]/div[1]/input"));
        origin.isDisplayed();
        origin.click();
        origin.sendKeys("Yogyakarta");

        WebElement originYK = driver.findElement(By.xpath("//div[@class=\"css-1m10txy\"]/div[8]"));
        originYK.isDisplayed();
        originYK.click();

//        //Memilih tujuan
//        WebElement destination = driver.findElement(By.xpath("//div[@class=\"location\"]/div[3]/input"));
//        destination.isDisplayed();
//        destination.click();
//        destination.sendKeys("Kutoarjo");
//
//        WebElement destinationKTA = driver.findElement(By.xpath("//div[@class=\"css-1m10txy\"]/div[3]"));
//        destinationKTA.isDisplayed();
//        destinationKTA.click();

//        //Memilih tanggal
//        WebElement date = driver.findElement(By.xpath("//div[@class=\"location\"]/div[3]"));
//        date.isDisplayed();
//        date.sendKeys("03 Jan 2023");

//        WebElement findTicket = driver.findElement(By.xpath("//div[@class=\"css-wkfdkq\"]"));
//        findTicket.isDisplayed();
//        findTicket.click();
//
//        WebElement buyTicket = driver.findElement(By.xpath("//div[@class=\"css-1yr2zok\"]/button[1]"));
//        buyTicket.isDisplayed();
//        buyTicket.click();
//
//        WebElement loginPage = driver.findElement(By.xpath("//div[@class=\"css-9z1sps\"]"));
//        loginPage.isDisplayed();
    }

    @BeforeMethod
    public void setup(){
        System.out.println("==========Browser is launching==========");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
