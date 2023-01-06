package CH8.page;

import CH8.Setup;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class homePage extends Setup {

    By sortButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
    }

    public void swipeToElementWithText(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
                                text)));
    }

    public void user_click_on_sort_button() {
        driver.findElement(sortButton).click();
    }
}