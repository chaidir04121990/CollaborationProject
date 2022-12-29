package belajar;

import belajar.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

    protected static AndroidDriver driver;
    protected static WebDriverWait wait;
    @BeforeTest
    public static void  setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi Note 7");
        cap.setCapability(MobileCapabilityType.UDID,"8934c4b5");
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", ".MainActivity");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(url,cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println(wait);
        System.out.println("aplikasi sukses terbuka");
    }

    @AfterTest
    public static void stopDriver() {
        driver.quit();
        System.out.println("aplikasi ditutup");
    }

}
