package belajar.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    WebDriverWait wait;
    AndroidDriver driver;

    public LoginPage(WebDriverWait wait, AndroidDriver driver){
        this.wait=wait;
        this.driver=driver;
    }
    By loginTextBox = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By passwordTextBox = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");

    By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginTextBox));
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginTextBox));
        driver.findElement(loginTextBox).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        String msg= (String) driver.findElement(errorMessage).getText();
        return msg;
    }
}
