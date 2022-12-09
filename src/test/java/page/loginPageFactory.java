package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameForm;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordForm;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement loginButton;

    public loginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username){
        usernameForm.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordForm.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
