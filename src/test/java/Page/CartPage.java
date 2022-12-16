package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement yourCart;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement buttonCheckout;

    public void validateCartPage(){
        Assert.assertEquals(yourCart.getText(),"YOUR CART");
    }

    public void checkOut(){
        buttonCheckout.click();
    }
}
