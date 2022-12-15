package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class checkoutCompletePage {
    WebDriver driver;

    public checkoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2")
    WebElement thankText;

    @FindBy(xpath = "//img[@class=\"pony_express\"]")
    WebElement ponyImage;

    @FindBy(xpath = "//button[@id=\"back-to-products\"]")
    WebElement backHomeBtn;

    // validate user is on checkout complete page by asserting url, title, image,
    // and backHome btn are displayed
    public void onCheckoutCompletePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        thankText.isDisplayed();
        ponyImage.isDisplayed();
        backHomeBtn.isDisplayed();
    }
}
