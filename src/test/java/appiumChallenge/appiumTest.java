package appiumChallenge;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import appiumChallenge.page.*;

public class appiumTest {

    public static AppiumDriver<MobileElement> driver;

    public static void setupDriver() throws MalformedURLException {
//        System.out.println("STARTING DRIVER...");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "H990");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "LGH9902acfe94f");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", 8);
//        capabilities.setCapability("deviceName", "H990");
//        capabilities.setCapability("automationName", "UIAutomator2");
//        capabilities.setCapability("udid", "LGH9902acfe94f");

        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        URL url = new URL("http://0.0.0.0:4723/");
        driver = new AppiumDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        System.out.println("APPIUM STARTING...");

    }

    public void scrollDisplay(AppiumDriver<MobileElement> driverParam, int startX, int startY, int endX, int endY){
        TouchAction<?> action  = new TouchAction<>(driverParam);
        action.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX,endY)).release().perform();
//        System.out.println("SCROLLING...");
    }

    public static void tearDown() {
//        System.out.println("QUITTING...");
        driver.quit();
    }

}
