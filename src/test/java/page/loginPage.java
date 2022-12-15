package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameInputText;

    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement passwordInputText;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement errorMessage;

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    public void inputUsername(String username){
        usernameInputText.sendKeys(username);
    }

    public void inputPassword(String Password){
        passwordInputText.sendKeys(Password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void pageValidation(){
        usernameInputText.isDisplayed();
        passwordInputText.isDisplayed();
        loginButton.isDisplayed();
    }

    public void checkPasswordNotMatch(){
        String expectedString = "Username and password do not match any user in this service";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkLockedAccount(){
        String expectedString = "Sorry, this user has been locked out";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkUsernameIsMandatory(){
        String expectedString = "Username is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkPasswordIsMandatory(){
        String expectedString = "Password is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkAllFiedlIsMandatory(){
        String expectedString = "Username is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }
}
