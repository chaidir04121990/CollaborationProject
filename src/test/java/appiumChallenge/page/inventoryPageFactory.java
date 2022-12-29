package appiumChallenge.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appiumChallenge.appiumTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class inventoryPageFactory extends appiumTest{

    public AppiumDriver<MobileElement> driverPage;

    public inventoryPageFactory(){
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
    }

    @FindBy(xpath = "//*[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement pageNavigationBar;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    WebElement sortingMenuButton;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup")
    List<WebElement> sortingMenuList;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    List<WebElement> itemPrices;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
//    WebElement inventoryListParent;
    List<WebElement> inventoryListParentElem;

    public List<ElementObj> elementMapping = new ArrayList<ElementObj>();

    @FindBy(xpath = "//*[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement cartNumber;

    @FindBy(xpath = "//*[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement cartButton;

    public String checkPageNavBar(){
        return (String) pageNavigationBar.getText();
    }

    public void sortingParent() {
        sortingMenuButton.click();
    }
    public void sortingMode(String sortingRule){

        if (Objects.equals(sortingRule, "az")){
            sortingMenuList.get(1).click();
        }
        else if (Objects.equals(sortingRule, "za")) {
            sortingMenuList.get(2).click();
        }
        else if (Objects.equals(sortingRule, "lohi")) {
            sortingMenuList.get(3).click();
        }
        else if (Objects.equals(sortingRule, "hilo")) {
            sortingMenuList.get(4).click();
        }
    }

    public Boolean checking(List<ElementObj> ls, WebElement elem) {
        if(ls.size() == 0) { return Boolean.TRUE; }
        for (ElementObj x : ls) {
            if (elem.toString() == x.title) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public List<ElementObj> getAllPrice(){
        List<WebElement> inventoryListParent = inventoryListParentElem;
        elementMapping.clear();
        int amn = 0;
        for (WebElement x:inventoryListParent) {
//            System.out.println("GETTING ELEMENT " + amn + " PRICE FROM " + inventoryListParent.size() + " ITEMS...");
            if (x.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")).size() > 0){
                String title = x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")).getText();
                String price = x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]")).getText();
                WebElement button = x.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
//                try {
//                    System.out.println(title);
//                    System.out.println(price);
//                    System.out.println(button.isDisplayed());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
                if (elementMapping == null || checking(elementMapping,x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")))){
//                    System.out.println("ADD ITEM " + amn + " TO LIST...");
                    elementMapping.add(new ElementObj(
                            title,
                            Double.parseDouble(price.replace("$","")),
                            button
                    ));
//                    button.click();
                }
            } else {
                continue;
//                System.out.println("Scrolling...");

            }
            amn++;
        }
//        System.out.println("There are "+ amn +" item(s) on this appiumChallenge.page!");
//        System.out.println("There are "+ elementMapping.size() +" item(s) on list!");

        return elementMapping;

    }

    public void addItems(int amount){
        List<WebElement> inventoryListParent = inventoryListParentElem;

        elementMapping.clear();
        int amn = 1;
        for (WebElement x:inventoryListParent) {
//            System.out.println("FOUND ITEM " + amn + " OF " + amount + " FROM " + inventoryListParent.size() + " ITEMS");
            List<WebElement> varElem = x.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
//            System.out.println(varElem);

            if (varElem.size() > 0){
                String title = x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")).getText();
                String price = x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]")).getText();
                WebElement button = x.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
//                try {
//                    System.out.println(title);
//                    System.out.println(price);
//                    System.out.println(button.isDisplayed());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
                if (elementMapping == null || checking(elementMapping,x.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")))){
//                    System.out.println("ADDING ITEM " + amn + " TO LIST");
                    elementMapping.add(new ElementObj(
                            title,
                            Double.parseDouble(price.replace("$","")),
                            button
                    ));
                    if (amn == amount){
//                        System.out.println("THIS IS THE ITEM TO BE SELECTED...");
                        button.click();
                        break;
                    }
                }
            }
            else {
                continue;
//                System.out.println("Scrolling...");
            }
            amn++;
        }

    }

    public int getCartNumber(){
        return Integer.parseInt(cartNumber.getText());
    }

    public void checkOut(){
        cartButton.click();
    }

}
