package SwaglabsTest.pages;

import SwaglabsTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BaseTest {

    By youCartHeading = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    By checkoutButton = By.id("test-CHECKOUT");
    By checkoutInformationHeading = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    By firstName = By.id("test-First Name");
    By lastName = By.id("test-Last Name");
    By postalCode = By.id("test-Zip/Postal Code");
    By continueButton = By.id("test-CONTINUE");

    public void validateYourCartPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(youCartHeading));
    }

    public void checkoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public void validateCheckoutInformationPage(){
        driver.findElement(checkoutInformationHeading).click();
    }

    public void inputFirstName(String firstname){
        driver.findElement(firstName).sendKeys(firstname);
    }

    public void inputLastName(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void inputPostalCode(String postalcode){
        driver.findElement(postalCode).sendKeys(postalcode);
    }

    public void continueButton(){
        driver.findElement(continueButton).click();
    }

    //server error

}
