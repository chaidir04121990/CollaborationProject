package challenge_8.page;

import challenge_8.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CheckoutDuaPage extends BaseTest {
    AppiumDriver<MobileElement> driverPage;
    Dimension size;

    public CheckoutDuaPage() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
        this.size = driverPage.manage().window().getSize();
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement chcekoutText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    WebElement finishBtn;

    public void onCheckoutDuaPage() {
        chcekoutText.isDisplayed();
    }

    // click finish button
    public void clickFinishBtn() {
        Boolean param = true;

        while (param) {
            try {
                finishBtn.click();
                param = false;
            } catch (Exception e) {
                scrollDisplay(this.driverPage, size.width / 2, size.height / 2, size.width / 2, (int) (size.height * 0.2));
            }
        }
    }
}