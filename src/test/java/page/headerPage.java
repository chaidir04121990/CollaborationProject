package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class headerPage {
    WebDriver driver;

    public headerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartButton;

    public void cartButton(){
        cartButton.click();
    }
}
