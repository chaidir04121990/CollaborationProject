package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver;

    By usernameForm = By.xpath("//*[@id=\"user-name\"]");
    By passwordForm = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("//*[@id=\"login-button\"]");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(String username){
        driver.findElement(usernameForm).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordForm).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
