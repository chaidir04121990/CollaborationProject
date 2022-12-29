package challenge_8;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
//    protected static AppiumDriver<MobileElement> driver;

    protected static AndroidDriver driver;
    @BeforeMethod
    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "1t5n4dh");
        cap.setCapability(MobileCapabilityType.UDID, "aeddd417");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

//        URL url = new URL("http://0.0.0.0:4723/wd/hub");
//        driver = new AppiumDriver<MobileElement>(url, cap);

        driver = new AndroidDriver(cap);
        System.out.println("Setup Done!!!");
    }

    @AfterMethod
    public static void teardown() {
        driver.quit();
    }

    public void scrollDisplay(AppiumDriver<MobileElement> driverParam, int startX, int startY, int endX, int endY){
        TouchAction<?> action  = new TouchAction<>(driverParam);
        action.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX,endY)).release().perform();
    }

//    public void scroll() {
//        Dimension dimensions = driver.manage().window().getSize();
//        int Startpoint = (int) (dimensions.getHeight() * 0.5);
//        int scrollEnd = (int) (dimensions.getHeight() * 0.5);
//        driver.swipe(200, Startpoint,200,scrollEnd,2000);
//    }

//    public static void reset() {
//        driver.terminateApp("com.swaglabsmobileapp");
//        driver.activateApp("com.swaglabsmobileapp");
//    }
}
