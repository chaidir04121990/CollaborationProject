package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class checkoutSummaryPage {
    WebDriver driver;

    public checkoutSummaryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"cancel\"]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement webHeader;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[1]")
    WebElement qtyLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[2]")
    WebElement descriptionLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]")
    WebElement paymentInfoLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]")
    WebElement valuePaymentInfoLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]")
    WebElement shippingInfoLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]")
    WebElement valueShippingInfoLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")
    WebElement itemTotalLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    WebElement taxLabel;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    WebElement totalLabel;


    public void finishButton(){
        finishButton.click();
    }

    public void cancelButton(){
        cancelButton.click();
    }

    public void pageValidation(){
        cancelButton.isDisplayed();
        webHeader.isDisplayed();
        qtyLabel.isDisplayed();
        descriptionLabel.isDisplayed();
        paymentInfoLabel.isDisplayed();
        valuePaymentInfoLabel.isDisplayed();
        shippingInfoLabel.isDisplayed();
        valueShippingInfoLabel.isDisplayed();
        itemTotalLabel.isDisplayed();
        taxLabel.isDisplayed();
        totalLabel.isDisplayed();
    }

    @FindBy(className = "inventory_item_price")
    List<WebElement> totalPriceInCart;
    public void verifyCalculation(){
        float subtotal = Float.parseFloat(itemTotalLabel.getText().replace("Item total: $",""));
        float tax = Float.parseFloat(taxLabel.getText().replace("Tax: $",""));
        float total = Float.parseFloat(totalLabel.getText().replace("Total: $",""));

        DecimalFormat formatData = new DecimalFormat("#.##");
        float valueOfTax = Float.parseFloat(formatData.format(subtotal * 8 / 100));
        float sumSubtotalAndTax = Float.parseFloat(formatData.format(subtotal + valueOfTax));


        List<WebElement> totalPrice = totalPriceInCart;
        List<String> totalPriceList = new ArrayList<>();
        for (WebElement p : totalPrice) {
            totalPriceList.add(String.valueOf(p.getText().replace("$","")));
        }

        List<Float> totalPriceListValue = totalPriceList.stream()
                .map(s -> Float.parseFloat(s))
                .collect(Collectors.toList());

        float sum = 0;
        for (int i = 0; i < totalPriceListValue.size(); i++) {
            sum += totalPriceListValue.get(i);
        }

        Assert.assertEquals(subtotal, sum);
        Assert.assertEquals(tax, valueOfTax);
        Assert.assertEquals(total, sumSubtotalAndTax);
    }
}
