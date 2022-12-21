package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class productPage {
    WebDriver driver;
    @FindBy (xpath = "//div[@class=\"header_secondary_container\"]/span[@class=\"title\" and text() =\"Products\"]")
    WebElement titleText;
    @FindBy (xpath = "//select[@class=\"product_sort_container\"]")
    WebElement sortButton;
    @FindBy (xpath = "//select[@class=\"product_sort_container\"]/option[@value=\"hilo\"]")
    WebElement sortItem;


    public productPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void validateLogin(){titleText.isDisplayed();}

    public void clickSortButton(){sortButton.click();}

    public void clickSortOption(){sortItem.click();}

    public void beforeFilterPrice(){
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));

        List <Double> beforeFilterPriceList = new ArrayList<>();

        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("S", "")));
        }
    }

    public void afterFilterPrice(){
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));

        List <Double> afterFilterPriceList = new ArrayList<>();

        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("S", "")));
        }
    }

    public void validateSorting(){}


}