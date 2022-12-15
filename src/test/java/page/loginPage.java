package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test=\"error\" and text()=\"Epic sadface: Username and password do not match any user in this service\"]")
    WebElement errorUsernameMsg;

    @FindBy(xpath = "h3")
    WebElement text;

    public loginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void errorUsernameMsgShow() {
        Assert.assertEquals(errorUsernameMsg.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        errorUsernameMsg.isDisplayed();
    }
}