package appiumChallenge.page;

import org.openqa.selenium.WebElement;

public class ElementObj {

    // sid is a Key
    String title;
    Double price;
    WebElement checkoutButton;

    // Initialize with constructor
    public ElementObj(String title, double price, WebElement checkoutButton) {
        this.title = title;
        this.price = price;
        this.checkoutButton = checkoutButton;
    }

    // return the value of sid
    public String getTitle() {
        return title;
    }

    // return the value of name
    public Double getPrice() {
        return price;
    }

    // return the value of name
    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}
