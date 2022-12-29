package SwaglabsTest.pages;

import SwaglabsTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {

    By productsHeading = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup");
    By productItem1 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]");
    By productItem2 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[2]");
    By sortButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By sortList = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    By selectLowtoHigh = By.xpath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView");

    public By validateOnPage(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(productsHeading));
//        wait.until(ExpectedConditions.presenceOfElementLocated(productItem1));
        return productsHeading;
    }

    public void clickSort(){
        driver.findElement(sortButton).click();
    }

    public void selectLowtoHigh(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(sortList));
        driver.findElement(selectLowtoHigh).click();
    }

//    public String itemLow(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(productItem1));
//        return (String) driver.findElement(productItem1).getText();
//    }

    public Float itemLow(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(productItem1));
        String price = driver.findElement(productItem1).getText();
        return (Float) Float.parseFloat(price.replaceAll("[^\\d.]", ""));
    }
    public Float itemHigh(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(productItem2));
        String price = driver.findElement(productItem2).getText();
        return (Float) Float.parseFloat(price.replaceAll("[^\\d.]", ""));
    }

}
