package challenge_8.page;

import challenge_8.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CheckoutSatuPage extends BaseTest {
    AppiumDriver<MobileElement> driverPage;

    public CheckoutSatuPage() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement title;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    WebElement postalCodeField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    WebElement continueBtn;

    // validate on checkout one page by asserting url and text are displayed
    public void onCheckoutSatuPage() {
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(), "CHECKOUT: INFORMATION");
        title.isDisplayed();
    }

    // input first name
    public void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    // input last name
    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    // input postal code
    public void inputPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    // click continue button
    public void clickContinueBtn() {
        continueBtn.click();
    }
}