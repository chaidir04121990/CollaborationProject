package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InformationPage {
    WebDriver driver;

    public  InformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement title;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement LastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement nextPage;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement overview;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement succesNotif;

    public void ValidatePage(){
        Assert.assertEquals(title.getText(),"CHECKOUT: YOUR INFORMATION");
    }

    public void firstname(String firstname){firstName.sendKeys(firstname);}

    public void lastname(String lastname){LastName.sendKeys(lastname);}

    public void zipCode(String zipCode){postalCode.sendKeys(zipCode);}

    public void gotoContinuePage(){nextPage.click();}

    public void validationOverviewPage(){Assert.assertEquals(overview.getText(),"CHECKOUT: OVERVIEW");}

    public void finishButton(){finishButton.click();}

    public void validateFinishOrder(){Assert.assertEquals(succesNotif.getText(),"THANK YOU FOR YOUR ORDER");}

}
