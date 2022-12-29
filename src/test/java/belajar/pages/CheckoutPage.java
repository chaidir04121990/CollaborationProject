package belajar.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage {

    AndroidDriver driver;
    WebDriverWait wait;
    public  CheckoutPage(AndroidDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    By titlePage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");
    By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");

    By titlePage2 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");
    By firstName = AppiumBy.accessibilityId("test-First Name");
    By lastName = AppiumBy.accessibilityId("test-Last Name");
    By zipCOde = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");
    By cancelButton = AppiumBy.accessibilityId("test-CANCEL");

    public void validateTitlePage1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(titlePage));
        Assert.assertEquals(driver.findElement(titlePage).getText(),"YOUR CART");
    }
    public void clickCheckout() {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()"+
                                        ".text(\"CHECKOUT\"))"
                        )
                )
        );
        driver.findElement(checkoutButton).click();
    }

    public void validateInformationPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(titlePage));
        Assert.assertEquals(driver.findElement(titlePage).getText(),"CHECKOUT: INFORMATION");
    }

    public void insertFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    public void insertLastName(String name){
        driver.findElement(lastName).sendKeys(name);
    }
    public void postalCode(String code){
        driver.findElement(zipCOde).sendKeys(code);
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

}
