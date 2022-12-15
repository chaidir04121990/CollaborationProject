package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class transactionSuccessfulPage {
    WebDriver driver;

    public transactionSuccessfulPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement thanksLabel;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/div")
    WebElement descLabel;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/img")
    WebElement image;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement webHeader;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    WebElement backButton;

    public void pageValidation(){
        thanksLabel.isDisplayed();
        descLabel.isDisplayed();
        image.isDisplayed();
        webHeader.isDisplayed();
    }

    public void backButton(){
        backButton.click();
    }
}
