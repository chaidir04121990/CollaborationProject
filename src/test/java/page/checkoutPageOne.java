package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;

public class checkoutPageOne {
    WebDriver driver;

    public checkoutPageOne(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement title;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id=\"first-name\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id=\"last-name\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@class=\"form_group\"]/input[@id=\"postal-code\"]")
    WebElement postalCodeField;

    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueBtn;

    // validate on checkout one page by asserting url and text are displayed
    public void onCheckoutPageOne() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(title.getText(), "CHECKOUT: YOUR INFORMATION");
        title.isDisplayed();
    }

    // input first name
    public void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    // input last name
    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    // input postal code
    public void inputPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    // click continue button
    public void clickContinueBtn() {
        continueBtn.click();
    }
}
