package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id = \"user-name\"]")
    WebElement usernameInputText;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id = \"password\"]")
    WebElement passwordInputText;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test=\"error\" and text()=\"Epic sadface: Username and Password is required\"]")
    WebElement errorPasswordMsg;

    public loginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        usernameInputText.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInputText.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void validateError() {
        Assert.assertEquals(errorPasswordMsg.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        errorPasswordMsg.isDisplayed();}
}