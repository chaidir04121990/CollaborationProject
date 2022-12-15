package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameInputText = By.xpath("//*[@id=\"user-name\"]");
    By passwordInputText = By.xpath("//*[@id=\"password\"]");
    By buttonLogin = By.xpath("//*[@id=\"login-button\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(String username){
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void buttonLogin(){
        driver.findElement(buttonLogin).click();
    }
}
