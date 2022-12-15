package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homePage {

    WebDriver driver;

    public homePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
    WebElement webHeader;

    @FindBy(xpath="//*[@id=\"inventory_container\"]/div")
    WebElement productList;

    @FindBy(xpath="//*[@id=\"remove-sauce-labs-backpack\"]")
    List<WebElement> price;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    WebElement dropdownSort;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    WebElement highToLow;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    WebElement lowToHigh;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    WebElement zToA;

    @FindBy(xpath="//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    WebElement aToZ;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement addProduct1ToCartButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement addProduct2ToCartButton;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    WebElement product1;

    @FindBy(className="inventory_item_price")
    List<WebElement> inventoryItemPrice;

    @FindBy(className="inventory_item_name")
    List<WebElement> inventoryItemName;

    public void checkProductList(){
        webHeader.isDisplayed();
        Assert.assertEquals(webHeader.getText(),"PRODUCTS");
        productList.isDisplayed();
    }

    public void setAddToCartButton(){
        addProduct1ToCartButton.click();
        addProduct2ToCartButton.click();
    }

    public void viewProduct1(){
        product1.click();
    }

    public void sortPriceDesc(){
        // Get Data Before Sort
        List<WebElement> beforeFilterPrice = inventoryItemPrice;
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // Dropdown Menu
        dropdownSort.click();
        highToLow.click();

        // Get Data After Sort Desc
        List<WebElement> afterFilterPrice = inventoryItemPrice;
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // Validation
        Collections.sort(beforeFilterPriceList,Collections.reverseOrder());
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);
    }

    public void sortPriceAsc(){
        // Get Data Before Sort
        List<WebElement> beforeFilterPrice = inventoryItemPrice;
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // Dropdown Menu
        dropdownSort.click();
        lowToHigh.click();

        // Get Data After Sort Desc
        List<WebElement> afterFilterPrice = inventoryItemPrice;
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        // Validation
        Collections.sort(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);
    }

    public void sortNameDesc(){
        // Get Data Before Sort
        List<WebElement> beforeFilterPrice = inventoryItemName;
        List<String> beforeFilterPriceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(String.valueOf(p.getText()));
        }

        // Dropdown Menu
        dropdownSort.click();
        zToA.click();

        // Get Data After Sort Desc
        List<WebElement> afterFilterPrice = inventoryItemName;
        List<String> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(String.valueOf(p.getText()));
        }

        // Validation
        Collections.sort(beforeFilterPriceList,Collections.reverseOrder());
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);
    }

    public void sortNameAsc(){
        // Get Data Before Sort
        List<WebElement> beforeFilterPrice = inventoryItemName;
        List<String> beforeFilterPriceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(String.valueOf(p.getText()));
        }

        // Dropdown Menu
        dropdownSort.click();
        aToZ.click();

        // Get Data After Sort Desc
        List<WebElement> afterFilterPrice = inventoryItemName;
        List<String> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(String.valueOf(p.getText()));
        }

        // Validation
        Collections.sort(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);
    }


}
