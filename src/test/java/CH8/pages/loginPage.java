package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class loginPage extends baseTest {

    String errorMsg = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView";

    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Username")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Password")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-LOGIN")));
    }

    public void wrongCredentials(){
        String expectedString = "Username and password do not match any user in this service";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkLockedAccount(){
        String expectedString = "Sorry, this user has been locked out";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkUsernameIsMandatory(){
        String expectedString = "Username is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkPasswordIsMandatory(){
        String expectedString = "Password is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkAllFiedlIsMandatory(){
        String expectedString = "Username is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void inputUsername(String username) {
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
    }
}