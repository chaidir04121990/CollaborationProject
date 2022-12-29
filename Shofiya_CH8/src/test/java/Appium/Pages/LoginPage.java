package Appium.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import Appium.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest{
    AndroidDriver driver;

    By username = By.id("test-username");
    By password = By.id("test-password");
    By loginButton = By.id("test-login");

    By productText = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public void validateOnLoginPage(){
        driver.findElement(username).isDisplayed();
        driver.findElement(password).isDisplayed();
        driver.findElement(loginButton).isDisplayed();
    }

    public void inputUsername(String username){
        By usernameTextBox = AppiumBy.accessibilityId("test-Username");
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void inputPassword(String password){
        By usernameTextBox = AppiumBy.accessibilityId("test-Password");
        driver.findElement(usernameTextBox).sendKeys(password);
    }

    public void clickLoginButton(){
        By LoginButton = By.xpath("//*[@content-desc=\"test-login\"]");
        driver.findElement(LoginButton).click();
    }

    public void validateOnHomepage(){
        driver.findElement(productText).isDisplayed();
    }

    public void showErrorMsg(){
        String expectedString = "Username and password do not match any user in this service";
        String actualString = driver.findElement(errorMsg).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

}
