package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement title;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    WebElement sortButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    WebElement priceHtL;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    WebElement sortingBox;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement sauceLabsBackpackadd2cart;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement saucelabsBikeLight2cart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement totalItem;

    public  void validateHomePage(){title.getText().equals("Products");}

    public void clickSortButton() { sortButton.click(); }

    public void sortpriceHtl(){
        priceHtL.isDisplayed();
        priceHtL.click();
    }

    public void validatepriceHtL(){
        Assert.assertEquals(sortingBox.getText(),"PRICE (HIGH TO LOW)");
    }

    public void addTwoItem(){
        sauceLabsBackpackadd2cart.click();
        saucelabsBikeLight2cart.click();
    }

    public void validateCart(){
        Assert.assertEquals(totalItem.getText(),"2");
    }

    public void move2CartPage(){
        cart.click();
    }
}
