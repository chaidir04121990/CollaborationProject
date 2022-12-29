package Appium.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import Appium.BaseTest;

public class CheckoutPage extends BaseTest {
    AndroidDriver driver;

    By item1 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    By item2 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
    By shoppingCart= By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    By yourCartText = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");

    By checkoutButton = By.id("test-CHECKOUT");

    By checkoutInformationText = By.xpath("");

    By firstname = By.id("test-First Name");

    By lastname = By.id("test-Last Name");
    By postalcode = By.id("test-Zip/Postal Code");

    By continueButton = By.id("test-CONTINUE");
    By checkoutOverviewText = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");
    By finishButton = By.id("test-FINISH");
    By checkoutCompleteText = By.xpath("");

    public void clickItem1(){

        driver.findElement(item1).click();
    }

    public void clickItem2(){
        driver.findElement(item2).click();
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCart).click();
    }

    public void validateOnCartPage(){
        driver.findElement(yourCartText).isDisplayed();
    }
    public void clickCheckoutButton(){
        By CheckoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
        driver.findElement(CheckoutButton).click();
    }

    public void validateOnInformationPage(){
        driver.findElement(checkoutInformationText).isDisplayed();
    }

    public void inputFirstname(){
        By firstnameTextBox = AppiumBy.accessibilityId("test-First Name");
        driver.findElement(firstnameTextBox).sendKeys(firstname);
    }

    public void inputLastname(){
        By lastnameTextBox = AppiumBy.accessibilityId("test-Last Name");
        driver.findElement(lastnameTextBox).sendKeys(lastname);
    }

    public void inputPostalCode(){
        By postalcodeTextBox  = AppiumBy.accessibilityId("test-Zip/Postal Code");
        driver.findElement(postalcodeTextBox ).sendKeys(postalcode);
    }

    public void clickContinueButton(){
        By ContinueButton = AppiumBy.accessibilityId("test-CONTINUE");
        driver.findElement(ContinueButton).click();
    }

    public void validateOnOverviewPage(){
        driver.findElement(checkoutOverviewText).isDisplayed();
    }

    public void clickFinishButton(){
        By FinishButton = AppiumBy.accessibilityId("test-FINISH");
        driver.findElement(FinishButton).click();
    }

    public void validateTransactionWasSuccessful(){
        driver.findElement(checkoutCompleteText).isDisplayed();
    }

}
