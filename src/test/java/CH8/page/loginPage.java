package CH8.page;

import CH8.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class loginPage extends BaseTest {
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]")
    WebElement swagTitle;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    WebElement usernameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    WebElement errorUsernameMsg;

    public void validateOnPage() {
        swagTitle.isDisplayed();
        usernameInput.isDisplayed();
        passwordInput.isDisplayed();
        loginButton.isDisplayed();
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // error message is shown
    public void errorUsernameMsgShow() {
        Assert.assertEquals(errorUsernameMsg.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        errorUsernameMsg.isDisplayed();
    }
}
