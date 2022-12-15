package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement item1;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement item2;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement shoppingChart;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement firstNameInputText;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement lastNameInputText;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement postalCodeInputText;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement finishButton;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickItem1(){
        item1.click();
    }

    public void clickItem2(){
        item2.click();
    }

    public void clickShoppingChart(){
        shoppingChart.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void inputFirstName(String firstname){
        firstNameInputText.sendKeys(firstname);
    }

    public void inputLastName(String lastname){
        lastNameInputText.sendKeys(lastname);
    }

    public void inputPostalCode(String postalcode){
        postalCodeInputText.sendKeys(postalcode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }
}
