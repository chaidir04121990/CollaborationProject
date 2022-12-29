package belajar.pages;

import belajar.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriverWait wait;
    AndroidDriver driver;
    public HomePage(WebDriverWait wait,AndroidDriver driver){
        this.wait=wait;
        this.driver=driver;
    }
    By productLabel = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView");
    By product1 = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");

    By filterButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    By lowToHigh = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView");
    By firstItem = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    By secondItem = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
    By totalItemInCart = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");
    By cartButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productLabel));
    }

    public void clickSortButton(){
        driver.findElement(filterButton).click();
    }

    public void clicklth(){
        wait.until(ExpectedConditions.presenceOfElementLocated(lowToHigh));
        driver.findElement(lowToHigh).click();
    }

    public void addFirstItem(){
        driver.findElement(secondItem).click();
    }
    public void addSecondItem(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstItem));
        driver.findElement(firstItem).click();
    }

    public String validateTotalItem(){
        return driver.findElement(totalItemInCart).getText();
    }

    public  void clickCartButton(){
        driver.findElement(cartButton).click();
    }

    public void validateSortLowToHigh() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        List<WebElement> price = driver.findElements(AppiumBy.accessibilityId("test-Price"));
        List<Double> priceList = new ArrayList<>();
        for (WebElement w : price){
            priceList.add(Double.valueOf(w.getText().replace("$","")));
        }

        Double product1 = priceList.get(0);
        Double product2 = priceList.get(1);
        Assert.assertTrue(product2>product1);
    }
}
