package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By addToCart1 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    By addToCart2 = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By checkoutButton = By.xpath("//*[@id=\"checkout\"]");
    By firstName = By.xpath("//*[@id=\"first-name\"]");
    By lastName = By.xpath("//*[@id=\"last-name\"]");
    By postalCode = By.xpath("//*[@id=\"postal-code\"]");
    By contInfoButton = By.xpath("//*[@id=\"continue\"]");
    By finishCheckoutButton = By.xpath("//*[@id=\"finish\"]");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    public void addToCart(){
        driver.findElement(addToCart1).click();
        driver.findElement(addToCart2).click();
    }
    public void Cart(){
        driver.findElement(cartButton).click();
    }
    public void checkoutClick() {
        driver.findElement(checkoutButton).click();
    }

    public void checkoutOne() {
        driver.findElement(firstName).sendKeys("Tiara");
        driver.findElement(lastName).sendKeys("Putri");
        driver.findElement(postalCode).sendKeys("43212");
        driver.findElement(contInfoButton).click();
    }

    public void checkoutTwo(){
        driver.findElement(finishCheckoutButton).click();
    }

}
