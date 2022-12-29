package SwaglabsTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BaseTest {

//    public static BaseTest<MobileElement> driver;
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    public static void setUpDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"1819");
        cap.setCapability(MobileCapabilityType.UDID,"HIAYS4FYOB6TYHT4");
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        cap.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(url,cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait = (WebDriverWait) driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void stopDriver(){
        driver.quit();
    }

//    public static void resetApp(){
//        driver.terminateApp("com.swaglabsmobileapp");
//        driver.activateApp("com.swaglabsmobileapp");
//    }

}
