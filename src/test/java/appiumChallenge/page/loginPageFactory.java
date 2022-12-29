package appiumChallenge.page;

import appiumChallenge.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory extends appiumTest{
    public AppiumDriver<MobileElement> driverPage;

    public loginPageFactory(){
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "//*[@content-desc=\"test-Username\"]")
    WebElement usernameForm;
    @FindBy(xpath = "//*[@content-desc=\"test-Password\"]")
    WebElement passwordForm;
    @FindBy(xpath = "//*[@content-desc=\"test-LOGIN\"]")
    WebElement loginButton;
    @FindBy(xpath = "//*[@content-desc=\"test-Error message\"]/*")
    WebElement errorMessage;

    public String checkPageNavBar(){
        String loginBTN =  loginButton.findElement(By.xpath("//android.widget.TextView")).getText();
        return loginBTN;
    }
    public void inputUsername(String username){
        usernameForm.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordForm.sendKeys(password);
    }

    public String checkErrorMessage(){
        return (String) errorMessage.getText();
    }

    public void clickLoginButton(){ loginButton.click(); }

}
