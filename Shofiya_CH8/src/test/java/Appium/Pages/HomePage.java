package Appium.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import Appium.BaseTest;

public class HomePage extends BaseTest {
    AndroidDriver driver;

    By sortButton = By.xpath("");
    By highToLowPrice = By.xpath("");

    public void clickSortButton(){
        By SortButton = By.xpath("");
        driver.findElement(sortButton).click();
    }

    public void clickFinishButton(){
        By HighToLowPrice = By.xpath("");
        driver.findElement(highToLowPrice).click();
    }

}

