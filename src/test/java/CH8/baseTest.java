package CH8;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class baseTest {
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;
    public static void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability( "appium:platformVersion", "12");
        capabilities.setCapability( "appium:deviceName", "Redmi Note 10 Pro");
        capabilities.setCapability("appium:udid", "f56a89e5");
        capabilities.setCapability( "appium:appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability( "appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(url,capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void stopDriver() {
        driver.quit();
    }

    public static void resetApp() {
        driver.terminateApp("com.swaglabsmobileapp");
        driver.activateApp("com.swaglabsmobileapp");
    }

}
