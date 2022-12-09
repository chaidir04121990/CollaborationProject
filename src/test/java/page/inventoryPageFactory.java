package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class inventoryPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement sortingMenuParent;

    @FindBy(xpath = "//option[@value=\"az\"]")
    WebElement sortingMenuChildAZ;

    @FindBy(xpath = "//option[@value=\"za\"]")
    WebElement sortingMenuChildZA;

    @FindBy(xpath = "//option[@value=\"lohi\"]")
    WebElement sortingMenuChildLohi;

    @FindBy(xpath = "//option[@value=\"hilo\"]")
    WebElement sortingMenuChildHilo;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]")
    WebElement inventoryListParent;
//    List<WebElement> inventoryList;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    WebElement cartButton;

    public inventoryPageFactory(WebDriver driverParam){
        this.driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    public void sorting(String sortingRule){
        sortingMenuParent.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String text = js.executeScript("return window.getComputedStyle(document.querySelector('.submitButton'),'::before').getPropertyValue('content')").toString();
        if (sortingRule == "az"){
            sortingMenuChildAZ.click();
        }
        else if (sortingRule == "za") {
            sortingMenuChildZA.click();
        }
        else if (sortingRule == "lohi") {
            sortingMenuChildLohi.click();
        }
        else if (sortingRule == "hilo") {
            sortingMenuChildHilo.click();
        }
    }

    public List<Double> getItemsPrice(){
        List<WebElement> inventoriesPrice = inventoryListParent.findElements(By.xpath("//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]"));

        List<Double> priceList = new ArrayList<>();

        for (WebElement x:inventoriesPrice) {
            priceList.add(Double.parseDouble(x.getText().replace("$","")));
        }

        return priceList;
    }

    public void addItems(int amount){
        List<WebElement> inventoryLists = inventoryListParent.findElements(By.xpath("//div[@class=\"inventory_item\"]//button"));

        for (int i = 0; i < amount; i++){
//            System.out.println(inventoryLists.get(i).getText());
            inventoryLists.get(i).click();
        }
    }

    public void checkOut(){
        cartButton.click();
    }

}
