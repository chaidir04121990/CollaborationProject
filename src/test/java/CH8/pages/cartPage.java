package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class cartPage extends baseTest {
    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Description")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Amount")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-REMOVE")));
    }

    public void checkoutButton() {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"CHECKOUT\"))"))).click();
    }

    public static void continueShoppingButton(){
        driver.findElement(AppiumBy.accessibilityId("test-CONTINUE SHOPPING")).click();
    }

    public static void removeButton(){
        driver.findElement(AppiumBy.accessibilityId("test-REMOVE")).click();
    }
}
