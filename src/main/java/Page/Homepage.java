package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {

    WebDriver driver;

    By sortContainer = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
    By sortHightoLow = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]");

    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    public void sortContainer(){
        driver.findElement(sortContainer).click();
    }

    public void descendantSort(){
        driver.findElement(sortHightoLow).click();
    }

}
