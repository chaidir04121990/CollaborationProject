package appiumChallenge.page;

import appiumChallenge.appiumTest;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class cartPageFactory extends appiumTest{

    AppiumDriver<MobileElement> driverPage;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement pageNavigationBar;


//    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView")
//    List<WebElement> inventoryListParent;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    WebElement checkoutButton;

    Dimension size;

    public cartPageFactory(){
        this.driverPage = driver;
//        System.out.println(driverPage);
        PageFactory.initElements(driverPage, this);
        this.size = driverPage.manage().window().getSize();
    }

    public String checkPageNavBar(){
        return pageNavigationBar.getText();
    }

    public void pressCheckoutButton(){
//        System.out.println(checkoutButton);
        Boolean param = true;

        while (param) {
            try {
//                System.out.println("FINDING BUTTON...");
                checkoutButton.click();
//                System.out.println("BUTTON CLICKED...");
                param = false;
            } catch (Exception e) {
                scrollDisplay(this.driverPage, size.width / 2, size.height / 2, size.width / 2, (int) (size.height * 0.2));
            }
        }
    }

}
