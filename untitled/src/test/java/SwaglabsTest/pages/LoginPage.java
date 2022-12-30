package SwaglabsTest.pages;

import SwaglabsTest.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {

    protected static AndroidDriver driver;
//    public loginPageFactory(){
//        this.driverPage = driver;
//        PageFactory.initElements(driverPage.this);
//    }
    By usernameField = By.id("test-Username");
    By passwordField = By.id("test-Password");
    By loginButton = By.id("test-LOGIN");
    By errorMessage = By.id("test-Error message");

    public By validateOnPage(){
//        System.out.println(wait);
//        System.out.println(usernameField);
//        System.out.println(passwordField);
//        System.out.println(loginButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        return usernameField;
    }

    public void inputUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String errorMessage(){
        return(String) driver.findElement(errorMessage).getText();
    }

}
