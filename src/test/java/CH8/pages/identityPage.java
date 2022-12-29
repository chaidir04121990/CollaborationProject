package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class identityPage extends baseTest {
    static String errorMsg = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView";

    public static void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-First Name")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Last Name")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Zip/Postal Code")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-CANCEL")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-CONTINUE")));
    }

    public static void clickContinueButton() {
        driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
    }

    public static void inputFirstname(String firstname) {
        driver.findElement(AppiumBy.accessibilityId("test-First Name")).sendKeys(firstname);
    }

    public static void inputLastname(String lastname) {
        driver.findElement(AppiumBy.accessibilityId("test-Last Name")).sendKeys(lastname);
    }

    public static void inputPostalCode(String postalcode) {
        driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).sendKeys(postalcode);
    }

    public static void cancelButton(){
        driver.findElement(AppiumBy.accessibilityId("test-CANCEL")).click();
    }

    public static void firstnameIsMandatory() {
        String expectedString = "First Name is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public static void lastnameIsMandatory() {
        String expectedString = "Last Name is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public static void postalCodeIsMandatory() {
        String expectedString = "Postal Code is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public static void allFieldIsMandatory() {
        String expectedString = "First Name is required";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(errorMsg)));
        String actualString = driver.findElement(AppiumBy.xpath(errorMsg)).getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }
}
