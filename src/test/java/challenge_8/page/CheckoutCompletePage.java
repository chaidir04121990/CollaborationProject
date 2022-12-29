package challenge_8.page;

import challenge_8.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CheckoutCompletePage extends BaseTest {
    AppiumDriver<MobileElement> driverPage;

    public CheckoutCompletePage() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement completeText;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    WebElement thankText;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement ponyImage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
    WebElement backHomeBtn;

    // validate user is on checkout complete page by asserting url, title, image,
    // and backHome btn are displayed
    public void onCheckoutCompletePage() {
        thankText.isDisplayed();
        ponyImage.isDisplayed();
        backHomeBtn.isDisplayed();
    }
}
