package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import junit.framework.Assert;
import java.util.ArrayList;
import java.util.List;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement productText;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement filter;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]/option[@value=\"za\"]")
    WebElement zToA;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]/option[@value=\"az\"]")
    WebElement aToZ;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]/option[@value=\"lohi\"]")
    WebElement lowToHighPrice;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]/option[@value=\"hilo\"]")
    WebElement highToLowPrice;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]")
    WebElement inventoryList;

    @FindBy(xpath = "//div[@class=\"inventory_item\"][1]/div/div/button")
    WebElement itemOneBtn;

    @FindBy(xpath = "//div[@class=\"inventory_item\"][2]/div/div/button")
    WebElement itemTwoBtn;

    @FindBy(xpath = "//div[@id=\"shopping_cart_container\"]")
    WebElement cartBtn;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]/span")
    WebElement cartValue;

    // validate user is on home page by asserting url and "PRODUCTS" text are
    // displayed
    public void onHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        productText.isDisplayed();
    }

    // asserting sorting by items' prices
    public List<Double> getItemsPrice() {
        List<WebElement> inventoryItemsPrice = inventoryList
                .findElements(By.xpath("//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]"));

        List<Double> itemsPriceList = new ArrayList<>();

        for (WebElement x : inventoryItemsPrice) {
            itemsPriceList.add(Double.parseDouble(x.getText().replace("$", "")));
        }
        return itemsPriceList;
    }

    // sorting items from high to low price
    // validating by checking the price
    public void sortHighToLowPrice() {
        filter.isDisplayed();
        filter.click();
        highToLowPrice.click();

        List<Double> itemList = getItemsPrice();

        for (int i = 0; i < itemList.size() - 1; i++) {
            Assert.assertTrue(itemList.get(i) >= itemList.get(i + 1));
        }
    }

    // adding x item to cart
    public void addItem(int x) {
        List<WebElement> itemsBtn = inventoryList
                .findElements(By.xpath("//div[@class=\"inventory_item\"]/div/div[@class=\"pricebar\"]/button"));

        for (int i = 0; i < x; i++) {
            itemsBtn.get(i).click();
        }
    }

    // go to cart page
    public void goToCartPage() {
        cartBtn.click();
    }
}
