package challenge_appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    public static void setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", "100000");

        driver = new AndroidDriver(capabilities);
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
