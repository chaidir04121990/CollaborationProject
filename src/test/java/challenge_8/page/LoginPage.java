package challenge_8.page;

import challenge_8.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.AppiumBy;

public class LoginPage extends BaseTest {
    public AppiumDriver<MobileElement> driverPage;

    public LoginPage() {
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    WebElement usernameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    WebElement loginBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    WebElement errorPasswordMsg;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]")
    WebElement swagTitle;

    // validate on login page
    public void validateOnLoginPage() {
        swagTitle.isDisplayed();
        usernameInput.isDisplayed();
        passwordInput.isDisplayed();
        loginBtn.isDisplayed();
    }

    // input username
    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    // input password
    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    // click login button
    public void clickLoginButton() {
        loginBtn.click();
    }

    // error message is shown
    public void errorPasswordMsgShow() {
        Assert.assertEquals(errorPasswordMsg.getText(),
                "Username and password do not match any user in this service.");
        errorPasswordMsg.isDisplayed();
    }
}
