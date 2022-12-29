package appiumChallenge.page;
import appiumChallenge.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkoutSecondPageFactory extends appiumTest {

    AppiumDriver<MobileElement> driverPage;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement pageNavigationBar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement ppp;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView")
    List<WebElement> inventoryItemPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    WebElement finishButton;
    Dimension size;

    public checkoutSecondPageFactory() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
        this.size = driverPage.manage().window().getSize();

    }

    public String checkPageNavBar(){
        System.out.println("1 " + pageNavigationBar.getText());
        System.out.println("2 " + ppp.toString());
        System.out.println("2 " + ppp.getText());
        System.out.println("3 " + pageNavigationBar.getText());
        return pageNavigationBar.getText();
    }

    public void finishCheckout(){
        Boolean param = true;

        while (param) {
            try {
                finishButton.click();
                param = false;
            } catch (Exception e) {
                scrollDisplay(1000, this.driverPage, size.width / 2, (int) (size.height * 0.6), size.width / 2, size.height * 0);
            }
        }
    }

}

