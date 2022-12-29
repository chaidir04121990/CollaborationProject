package appiumChallenge.page;

import appiumChallenge.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutFirstPageFactory extends appiumTest{

    AppiumDriver<MobileElement> driverPage;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement pageNavigationBar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement ppp;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    WebElement firstName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    WebElement lastName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    WebElement zipCode;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    WebElement continueButton;
    Dimension size;

    public checkoutFirstPageFactory() {
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

    public void setFirstName(String param){
//        System.out.println(param);
        firstName.sendKeys(param);
    }

    public void setLastName(String param){
//        System.out.println(param);
        lastName.sendKeys(param);
    }

    public void setZipCode(String param){
//        System.out.println(param);
        zipCode.sendKeys(param);
    }

    public void continueCheckout(){
//        System.out.println(continueButton);
        Boolean param = true;

        while (param) {
            try {
//                System.out.println("FINDING BUTTON...");
                continueButton.click();
//                System.out.println("BUTTON CLICKED...");
                param = false;
            } catch (Exception e) {
                scrollDisplay(this.driverPage, size.width / 2, size.height / 2, size.width / 2, (int) (size.height * 0.2));
            }
        }
    }

}

