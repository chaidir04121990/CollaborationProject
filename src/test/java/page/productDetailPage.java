package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productDetailPage {
    WebDriver driver;

    public productDetailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    WebElement backButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement addProductToCartButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    WebElement productNameLabel;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
    WebElement productDescriptionLabel;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    WebElement productPriceLabel;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")
    WebElement productImage;

    public void backButton(){
        backButton.click();
    }

    public void addProductToCartButton(){
        addProductToCartButton.click();
    }

    public void pageValidation(){
        backButton.isDisplayed();
        addProductToCartButton.isDisplayed();
        productNameLabel.isDisplayed();
        productDescriptionLabel.isDisplayed();
        productPriceLabel.isDisplayed();
        productImage.isDisplayed();
    }
}
