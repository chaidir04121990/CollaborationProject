package appiumChallenge.page;
import appiumChallenge.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutCompletePageFactory extends appiumTest{

    AppiumDriver<MobileElement> driverPage;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement pageNavigationBar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement ppp;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup")
    WebElement completeGroup;

    WebElement completeMessage1, completeMessage2, completeMessageImage;


    public checkoutCompletePageFactory() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    public checkoutCompleteMessage checkPageNavBar(){
        System.out.println("1 " + pageNavigationBar.getText());
        System.out.println("2 " + ppp.toString());
        System.out.println("2 " + ppp.getText());
        System.out.println("3 " + pageNavigationBar.getText());
        this.completeMessage1 = completeGroup.findElement(By.xpath("//android.widget.TextView[1]"));
        this.completeMessage2 = completeGroup.findElement(By.xpath("//android.widget.TextView[2]"));
        this.completeMessageImage = completeGroup.findElement(By.xpath("//android.widget.ImageView"));

        return new checkoutCompleteMessage(pageNavigationBar, completeMessage1, completeMessage2, completeMessageImage);
    }



}

