package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.text.DecimalFormat;

public class overviewPage extends baseTest {
    static String calc = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView";

    public static void validateOnPage() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Description")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Amount")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-CHECKOUT: OVERVIEW")));
    }

    public static void finishButton() {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"FINISH\"))"))).click();
    }

    public static void cancelButton(){
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"CANCEL\"))"))).click();
    }
}
