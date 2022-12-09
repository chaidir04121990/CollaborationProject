package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class stepTwoPageFactory {


    WebDriver driver;

    @FindBy(xpath = "//button[@id=\"finish\"]")
    WebElement finishButton;

    public stepTwoPageFactory(WebDriver driverParam){
        this.driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    public void finishStep(){
        finishButton.click();
    }



}
