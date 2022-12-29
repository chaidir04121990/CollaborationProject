package appiumChallenge.page;

import appiumChallenge.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class loginPageFactory extends appiumTest{

//    WebDriver driver;
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
//        System.out.println(loginBTN);
        return loginBTN;
    }
    public void inputUsername(String username){
//        System.out.println(username);
        usernameForm.sendKeys(username);
    }

    public void inputPassword(String password){
//        System.out.println(password);
        passwordForm.sendKeys(password);
    }

    public String checkErrorMessage(){
        return (String) errorMessage.getText();
    }

    public void clickLoginButton(){ loginButton.click(); }

}
