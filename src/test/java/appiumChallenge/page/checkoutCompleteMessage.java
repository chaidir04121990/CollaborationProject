package appiumChallenge.page;

import org.openqa.selenium.WebElement;

public class checkoutCompleteMessage {

    public String pageNavText = "";
    public String message1 = "";
    public String message2 = "";
    public WebElement imageMessage = null;

    public checkoutCompleteMessage(WebElement param1, WebElement param2, WebElement param3, WebElement imageParam) {
        this.pageNavText = param1.getText();
        this.message1 = param2.getText();
        this.message2 = param3.getText();
        this.imageMessage = imageParam;
    }

}
