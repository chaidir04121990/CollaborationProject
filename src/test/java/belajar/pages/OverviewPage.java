package belajar.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OverviewPage {
    AndroidDriver driver;
    WebDriverWait wait;
    public  OverviewPage(AndroidDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    By titlePage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");
    By finishButton = AppiumBy.accessibilityId("test-FINISH");
    By thanksOrderMessage = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");

    public void validateOverviewPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(titlePage));
        Assert.assertEquals(driver.findElement(titlePage).getText(),"CHECKOUT: INFORMATION");
    }
    public void clickFinishButton(){
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()"+
                                        ".text(\"FINISH\"))"
                        )
                )
        );
        driver.findElement(finishButton).click();
    }

    public void validateMessageSucces(){
        wait.until(ExpectedConditions.presenceOfElementLocated(thanksOrderMessage));
        Assert.assertEquals(driver.findElement(thanksOrderMessage).getText(),"THANK YOU FOR YOU ORDER");
    }
}
