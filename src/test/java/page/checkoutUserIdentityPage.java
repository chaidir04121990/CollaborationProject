package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class checkoutUserIdentityPage {
    WebDriver driver;

    public checkoutUserIdentityPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement firstnameInputText;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement lastnameInputText;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement postalCodeInputText;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"cancel\"]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement webHeader;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    WebElement errorMessage;

    public void inputFirstname(String firstname){
        firstnameInputText.sendKeys(firstname);
    }

    public void inputLastname(String lastname){
        lastnameInputText.sendKeys(lastname);
    }

    public void inputPostalCode(String postalCode){
        postalCodeInputText.sendKeys(postalCode);
    }

    public void continueButton(){
        continueButton.click();
    }

    public void pageValidation(){
        cancelButton.isDisplayed();
        webHeader.isDisplayed();
        continueButton.isDisplayed();
        postalCodeInputText.isDisplayed();
        lastnameInputText.isDisplayed();
        firstnameInputText.isDisplayed();
    }

    public void cancelButton(){
        cancelButton.click();
    }

    public void checkAllFieldIsMandatory(){
        String expectedString = "First Name is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkFirstnameIsMandatory(){
        String expectedString = "First Name is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkLastnameIsMandatory(){
        String expectedString = "Last Name is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }

    public void checkPostalCodeIsMandatory(){
        String expectedString = "Postal Code is required";
        String actualString = errorMessage.getText();
        Assert.assertTrue(actualString.contains(expectedString));
    }
}
