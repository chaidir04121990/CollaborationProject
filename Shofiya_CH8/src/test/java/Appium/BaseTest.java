package Appium;

// import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
   // public static AppiumDriver<MobileElement> driver;
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"sdk_gphone64_arm64");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        capabilities.setCapability("appPackage","com.swaglabsmobileapp");
        capabilities.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("automationName","UiAutomator2");

        //URL url = new URL("http://0.0.0.0:4723/wd/hub");
        //driver = new AppiumDriver<MobileElement>(url,cap);
        driver = new AndroidDriver(capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }
}
