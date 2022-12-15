package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;

public class checkoutPageTwo {
    WebDriver driver;

    public checkoutPageTwo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"title\" and text()=\"Checkout: Overview\"]")
    WebElement chcekoutText;

    @FindBy(xpath = "//button[@id=\"finish\"]")
    WebElement finishBtn;

    // validate user is on checkout two page by asserting url and checkout text
    public void onCheckoutPageTwo() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        chcekoutText.isDisplayed();
    }

    // click finish button
    public void clickFinishBtn() {
        finishBtn.click();
    }
}
