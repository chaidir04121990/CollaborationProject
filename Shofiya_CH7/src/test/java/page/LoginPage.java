package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameInputText;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordInputText;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        usernameInputText.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordInputText.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}


