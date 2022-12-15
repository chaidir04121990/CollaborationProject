package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;
    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test=\"error\" and text()=\"Epic sadface: Username and password do not match any user in this service\"]")
    WebElement errorPasswordMsg;

    @FindBy(xpath = "h3")
    WebElement text;

    // go to login page
    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
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
                "Epic sadface: Username and password do not match any user in this service");
        errorPasswordMsg.isDisplayed();
    }
}
