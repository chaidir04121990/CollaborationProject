package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class stepOnePageFactory {

    WebDriver driver;

    @FindBy(xpath = "//input[@id=\"first-name\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@id=\"last-name\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id=\"postal-code\"]")
    WebElement postalCode;
    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueButton;

    public stepOnePageFactory(WebDriver driverParam){
        this.driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    public void inputForm(String param, String data){
        if (param == "firstName") {
            firstName.sendKeys(data);
        }
        else if (param == "lastName") {
            lastName.sendKeys(data);
        }
        else if (param == "postalCode") {
            postalCode.sendKeys(data);
        }

    }

    public void continueStep(){
        continueButton.click();
    }

}
