package page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;

public class cartPage {
    WebDriver driver;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"header_secondary_container\"]/span")
    WebElement cartPageTitle;

    @FindBy(xpath = "//button[@data-test=\"checkout\"]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class=\"cart_list\"]")
    WebElement cartList;

    // validate on cart page by assreting url and text
    public void onCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPageTitle.getText(), "YOUR CART");
        cartPageTitle.isDisplayed();
    }

    // count items in cart and assert the amount of items in cart equal to x
    public void countItems() {
        homePage hp = new homePage(driver);
        List<WebElement> itemsOnCart = cartList.findElements(By.xpath("//div[@class=\"cart_item\"]"));

        Assert.assertEquals(itemsOnCart.size(), hp.x);
    }

    // click checkout button
    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }
}
