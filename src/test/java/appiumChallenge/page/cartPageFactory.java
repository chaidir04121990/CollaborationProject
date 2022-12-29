package appiumChallenge.page;

import appiumChallenge.appiumTest;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class cartPageFactory extends appiumTest{

    AppiumDriver<MobileElement> driverPage;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement pageNavigationBar;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    WebElement checkoutButton;

    Dimension size;

    public cartPageFactory(){
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
        this.size = driverPage.manage().window().getSize();
    }

    public String checkPageNavBar(){
        return pageNavigationBar.getText();
    }

    public void pressCheckoutButton(){
        Boolean param = true;

        while (param) {
            try {
                checkoutButton.click();
                param = false;
            } catch (Exception e) {
                scrollDisplay(1000, this.driverPage, size.width / 2, (int) (size.height * 0.6), size.width / 2, size.height * 0);
            }
        }
    }

}
