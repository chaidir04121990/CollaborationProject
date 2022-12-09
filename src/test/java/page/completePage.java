package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class completePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[@class=\"complete-header\"]")
    WebElement h2ThankYou;

    @FindBy(xpath = "//div[@class=\"complete-text\"]")
    WebElement divThankYou;
    public completePage(WebDriver driverParam){
        this.driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    public String finishtext1(){
        return h2ThankYou.getText();
    }

    public String finishtext2(){
        return divThankYou.getText();
    }


}
