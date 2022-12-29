package CH8.stepDef;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class detailProductDef extends baseTest {
    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-BACK TO PRODUCTS")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Image Container")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Description")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Inventory item page")));
        wait.until(ExpectedConditions.presenceOfElementLocated(new AppiumBy.ByAndroidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                ".resourceIdMatches(\".*test-Price\"))"))));
    }

    public static void backToProductsButton(){
        driver.findElement(AppiumBy.accessibilityId("test-BACK TO PRODUCTS")).click();
    }

    public void addToCartButton() {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"ADD TO CART\"))"))).click();
    }
}
