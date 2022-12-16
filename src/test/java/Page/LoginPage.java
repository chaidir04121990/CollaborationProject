package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input#user-name")
    WebElement usrnameInput;

    @FindBy(css = "input#password")
    WebElement passwordInput;

    @FindBy(css = "input#login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement errorMessage;

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void inputUsername(String username){usrnameInput.sendKeys(username);}

    public void inputPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickButtonLogin(){
        loginButton.click();
    }

    public void validateErrorLogin() {
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
