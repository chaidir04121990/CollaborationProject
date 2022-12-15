package page;

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

    @FindBy(xpath = "//div[@class=\"cart_item\"]")
    WebElement itemInCart;

    // validate on cart page by assreting url and text
    public void onCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPageTitle.getText(), "YOUR CART");
        cartPageTitle.isDisplayed();
    }

    // click checkout button
    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

}
