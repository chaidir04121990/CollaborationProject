package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class shoppingCartPage {
    WebDriver driver;

    public shoppingCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement webHeader;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[1]")
    WebElement qtyLabel;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[2]")
    WebElement descriptionLabel;

    @FindBy(className = "cart_quantity")
    List<WebElement> totalProductInCart;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement totalProductInCartLogo;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-bike-light\"]")
    WebElement removeProduct1ToCartButton;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    WebElement removeProduct2ToCartButton;

    public void verifyTotalProductInCart(){
        List<WebElement> totalProduct = totalProductInCart;
        List<Integer> totalProductList = new ArrayList<>();
        for (WebElement p : totalProduct) {
            totalProductList.add(Integer.valueOf(p.getText()));
        }

        int sum = 0;
        for (int i = 0; i < totalProductList.size(); i++) {
            sum += totalProductList.get(i);
        }

        int shoppingCartBadge = Integer.parseInt(totalProductInCartLogo.getText());
        Assert.assertEquals(sum,shoppingCartBadge);
    }

    public void checkoutButton(){
        checkoutButton.click();
    }

    public void removeButton(){
        removeProduct1ToCartButton.click();
        removeProduct2ToCartButton.click();
    }

    public void pageValidation(){
        checkoutButton.isDisplayed();
        webHeader.isDisplayed();
        qtyLabel.isDisplayed();
        continueShoppingButton.isDisplayed();
        descriptionLabel.isDisplayed();
    }

}
