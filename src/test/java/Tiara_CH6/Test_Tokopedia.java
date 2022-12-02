package Tiara_CH6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

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
//        WebElement destinationKTA = driver.findElement(By.xpath("//div[@class=\"css-1m10txy\"]/div[2]"));
//        destinationKTA.isDisplayed();
//        destinationKTA.click();

//        //Memilih tanggal
//        WebElement date = driver.findElement(By.xpath("//div[@class=\"css-189ny3q\"]"));
//        date.isDisplayed();
//        date.click();
//
//        WebElement chooseDate = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div[1]/div/div/div[2]/section/div[5]/div[2]/table[2]/tbody/tr[5]/td[6]"));
//        chooseDate.isDisplayed();
//        chooseDate.click();

        WebElement findTicket = driver.findElement(By.xpath("//div[@class=\"css-wkfdkq\"]/button"));
        findTicket.isDisplayed();
        findTicket.click();

//        WebElement listTicket = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[1]/div"));
//        listTicket.isDisplayed();
        WebElement buyTicket = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/header/section/div[3]/div[1]"));
        buyTicket.isDisplayed();
//        buyTicket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"css-1yr2zok\"]/button[1]")));
//        buyTicket.isDisplayed();
//        buyTicket.click();
//
//        WebElement loginPage = driver.findElement(By.xpath("//div[@class=\"css-9z1sps\"]"));
//        loginPage.isDisplayed();

//        Jadi ini ceritanya mau beli tiket gitu, tapi error terus karena katanya DOM nya ke update jadi harusnya pake WebDriverWait dulu gitu, cuman aku coba ga bisa2 :(
//        Source : https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document

    }

    @BeforeMethod
    public void setup(){
        System.out.println("==========Browser is launching==========");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
