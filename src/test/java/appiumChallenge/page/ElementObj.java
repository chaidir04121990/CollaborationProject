package appiumChallenge.page;

import org.openqa.selenium.WebElement;

public class ElementObj {

    String title;
    Double price;
    WebElement checkoutButton;

    public ElementObj(String title, double price, WebElement checkoutButton) {
        this.title = title;
        this.price = price;
        this.checkoutButton = checkoutButton;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}
