package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id = \"user-name\"]")
    WebElement usernameInputText;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id = \"password\"]")
    WebElement passwordInputText;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"error-message-container error\"]/h3[@data-test=\"error\"]")
    WebElement errorMessage;

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

    public void validateError(){errorMessage.isDisplayed();}
}