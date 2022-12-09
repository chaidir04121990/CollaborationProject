package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"cart_list\"]")
    WebElement cartList;

    @FindBy(xpath = "//button[@id=\"continue-shopping\"]")
    WebElement backButton;

    @FindBy(xpath = "//button[@id=\"checkout\"]")
    WebElement checkoutButton;

    public cartPageFactory(WebDriver driverParam){
        this.driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    public int countItems(){
        List<WebElement> items = cartList.findElements(By.xpath("//div[@class=\"cart_item\"]"));
        return items.size();
    }

    public void removeItem(int x){
        List<WebElement> itemsList = cartList.findElements(By.xpath("//div[@class=\"cart_item\"]//div[@class=\"item_pricebar\"]/button"));
        if (x >= itemsList.size()){
            System.out.println("Incorrect Amount of Removed Item(s) (" + x + " vs " + itemsList.size() + ")");
        }
        else {
            for (int i = 0; i < x; i++) {
//            System.out.println(itemsList.get(i).getText());
                itemsList.get(i).click();
            }
        }
    }

    public void continueCheckout(){
        checkoutButton.click();
    }


}
