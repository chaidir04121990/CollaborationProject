package challenge_8.page;

import challenge_8.BaseTest;
import junit.framework.Assert;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomePage extends BaseTest {
    AppiumDriver<MobileElement> driverPage;

    public HomePage() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement productText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    WebElement sortingBtn;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement AToZ;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    WebElement ZToA;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView")
    WebElement lowToHighPrice;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.TextView")
    WebElement highToLowPrice;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    WebElement addBtnProduct1;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement cartBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement cartValue;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    WebElement productList;

    public void onHomePage(){
        productText.isDisplayed();
    }

    public void clickSortingBtn(){
        sortingBtn.click();
    }

    public void clickLowToHighBtn(){
        lowToHighPrice.click();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void addToCartProduct(){
        addBtnProduct1.click();
    }

    public void validateSorting(){
        List<WebElement> listProductPrices = productList.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));

        for (int i = 0; i < listProductPrices.size() - 1; i++) {
            Assert.assertTrue(  Double.parseDouble(listProductPrices.get(i).getText().replace("$", "")) >= Double.parseDouble(listProductPrices.get(i+1).getText().replace("$", "")));
        }
    }

    public String getCartNumber(){
        System.out.println(cartValue.getText());
        return cartValue.getText();
    }
}