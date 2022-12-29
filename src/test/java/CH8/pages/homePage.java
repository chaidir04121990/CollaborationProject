package CH8.pages;

import CH8.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class homePage extends baseTest {

    static String sortLabel = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]";
    static String sortOption = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup";
    static String sortButton = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView";

    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-ADD TO CART")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Modal Selector Button")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart drop zone")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item title")));
    }

    public void addOneProduct() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-ADD TO CART")));
        driver.findElement(AppiumBy.accessibilityId("test-ADD TO CART")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-REMOVE")));
    }

    public void addTwoProduct() {
        homePage homePage = new homePage();
        homePage.addOneProduct();
        homePage.addOneProduct();
    }

    public void addThreeProduct() {
        homePage homePage = new homePage();
        homePage.addTwoProduct();
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"Sauce Labs Bolt T-Shirt\"))")));
        homePage.addOneProduct();
    }

    public void addFourProduct() {
        homePage homePage = new homePage();
        homePage.addThreeProduct();
        homePage.addOneProduct();
    }

    public void addFiveProduct() {
        homePage homePage = new homePage();
        homePage.addFourProduct();
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()" +
                                        ".text(\"Sauce Labs Onesie\"))")));
        homePage.addOneProduct();
    }

    public void addSixProduct() {
        homePage homePage = new homePage();
        homePage.addFiveProduct();
        homePage.addOneProduct();
    }

    public void clickCartButton() {
        driver.findElement(AppiumBy.accessibilityId("test-Cart")).click();
    }

    public static void clickSortButton() {
        driver.findElement(AppiumBy.xpath(sortButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath(sortLabel)));
    }

    public void clickLohiButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath(sortLabel)));
        driver.findElement(AppiumBy.xpath(sortOption+"[4]/android.view.ViewGroup/android.widget.TextView")).click();
    }

    public void validationSortLowToHiPrice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        List<WebElement> afterFilterPrice =  driver.findElements(AppiumBy.accessibilityId("test-Price"));
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Double product1 = afterFilterPriceList.get(0);
        Double product2 = afterFilterPriceList.get(1);
        Assert.assertTrue(product1<product2);
    }

    public void clickHiloButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath(sortLabel)));
        driver.findElement(AppiumBy.xpath(sortOption+"[5]/android.view.ViewGroup/android.widget.TextView")).click();
    }

    public void validationSortHiToLowPrice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Price")));
        List<WebElement> afterFilterPrice =  driver.findElements(AppiumBy.accessibilityId("test-Price"));
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Double product1 = afterFilterPriceList.get(0);
        Double product2 = afterFilterPriceList.get(1);
        Assert.assertTrue(product1>product2);
    }

    public void clickAscAlphabetButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath(sortLabel)));
        driver.findElement(AppiumBy.xpath(sortOption+"[2]/android.view.ViewGroup/android.widget.TextView")).click();
    }

    public void validationSortAToZ() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item title")));
        List<WebElement> afterFilterPrice =  driver.findElements(AppiumBy.accessibilityId("test-Item title"));
        List<String> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(String.valueOf(p.getText()));
        }

        String product1 = afterFilterPriceList.get(0);
        String product2 = afterFilterPriceList.get(1);

        int compare = product1.compareTo(product2);
        Assert.assertTrue(compare<0);
    }

    public void clickDescAlphabetButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy
                .xpath(sortLabel)));
        driver.findElement(AppiumBy.xpath(sortOption+"[3]/android.view.ViewGroup/android.widget.TextView")).click();
    }

    public void validationSortZToA() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Item title")));
        List<WebElement> afterFilterPrice =  driver.findElements(AppiumBy.accessibilityId("test-Item title"));
        List<String> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(String.valueOf(p.getText()));
        }

        String product1 = afterFilterPriceList.get(0);
        String product2 = afterFilterPriceList.get(1);

        int compare = product1.compareTo(product2);
        Assert.assertTrue(compare>0);
    }
}
