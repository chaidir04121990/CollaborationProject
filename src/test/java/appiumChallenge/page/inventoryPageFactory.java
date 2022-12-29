package appiumChallenge.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appiumChallenge.appiumTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class inventoryPageFactory extends appiumTest{

    public AppiumDriver<MobileElement> driverPage;
    Dimension size;

    public inventoryPageFactory(){
        this.driverPage = driver;
        PageFactory.initElements(driverPage, this);
        this.size = driverPage.manage().window().getSize();

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
    List<WebElement> inventoryListParentElem;


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

    public Boolean checking(List<ElementObj> ls, String elem) {
        if(ls.size() == 0) { return Boolean.TRUE; }
        for (ElementObj x : ls) {
            if (elem == x.title) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public List<ElementObj> getAllPrice(){
        List<ElementObj> ObjList = new ArrayList<ElementObj>();

        int flag = 1;
        while (flag != 0){

            List<WebElement> inventoryList = getitemList();

            flag = inventoryList.size();
            if (flag == 0){
                break;
            }

            for (int j = 0; j < 2; j++){
                List<WebElement> varElem = inventoryList.get(j).findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
                if (varElem.size() > 0){
                    String title = inventoryList.get(j).findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")).getText();
                    String price = inventoryList.get(j).findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]")).getText().replace("$","");
                    if (ObjList == null || checking(ObjList,title))
                        ObjList.add(new ElementObj(
                            title,
                            Double.parseDouble(price),
                            null
                            )
                    );
                }
            }

            scrollDisplay(1000, this.driverPage, size.width / 2, (int) (size.height * 0.6), size.width / 2, size.height * 0);
        }
        return ObjList;

    }

    public List<WebElement> getitemList(){
        return inventoryListParentElem;
    }

    public void addItems(int amount){
        scrollDisplay(60, this.driverPage, size.width / 2, (int) (size.height * 0.3), size.width / 2, (int) (size.height * 0.8));

        int amn = 0;
        int i = 0;
        while (amn != amount){
            List<WebElement> inventoryList = getitemList();
            List<WebElement> varElem = inventoryList.get(i).findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));

            if (varElem.size() > 0){
                String title = inventoryList.get(i).findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]")).getText();
                String price = inventoryList.get(i).findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]")).getText();
                WebElement button = inventoryList.get(i).findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));

                button.click();

                i++;
                amn++;

            }
            else {
                scrollDisplay(1000, this.driverPage, size.width / 2, (int) (size.height * 0.6), size.width / 2, size.height * 0);
                i = 0;
            }
        }
    }

    public int getCartNumber(){
        return Integer.parseInt(cartNumber.getText());
    }

    public void checkOut(){
        cartButton.click();
    }

}
