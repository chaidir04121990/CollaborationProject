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

    @FindBy(xpath = "//div[@class=\"summary_info_label\" and text()=\"Payment Information:\"]")
    WebElement paymentLabel;

    @FindBy(xpath = "//div[@class=\"summary_info_label\" and text()=\"Payment Information:\"]/following-sibling::div[1]")
    WebElement paymentInfo;

    @FindBy(xpath = "//div[@class=\"summary_info\"]/div[3]")
    WebElement shippingLabel;

    @FindBy(xpath = "//div[@class=\"summary_info\"]/div[4]")
    WebElement shippingInfo;

    @FindBy(xpath = "//div[@class=\"summary_subtotal_label\"]")
    WebElement subTotalLabel;

    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
    WebElement taxLabel;

    @FindBy(xpath = "//div[@class=\"summary_total_label\"]")
    WebElement totalLabel;

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
