package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class completePage extends baseTest {

    public static void validateOnPage() throws InterruptedException {
        Thread.sleep(5000);
        // Text 1
        String expectedString1 = "THANK YOU FOR YOU ORDER";
        String actualString1 = driver.findElement(AppiumBy.xpath("\t\n" +
                "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        Assert.assertTrue(actualString1.contains(expectedString1));

        // Text 2
        String expectedString2 = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String actualString2 = driver.findElement(AppiumBy.xpath("\t\n" +
                "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        Assert.assertTrue(actualString2.contains(expectedString2));

        // Image
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath("\t\n" +
                        "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.ImageView")));

        // Button Back
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-BACK HOME")));
    }

    public static void backHomeButton(){
        driver.findElement(AppiumBy.accessibilityId("test-BACK HOME")).click();
    }
}
