package belajar.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FilterPage {

    By priceProduct1 = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    By priceProduct2 = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[2]");

}
