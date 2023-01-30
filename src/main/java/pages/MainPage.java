package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import utils.BrowserUtils;

public class MainPage extends BaseForm {

    private Button alertsFrameButton = new Button(By.xpath("//*/h5[contains(text(), 'Alerts, Frame & Windows')]"), "alertsFrameButton");
    private Button elementsButton = new Button(By.xpath("//*/h5[contains(text(), 'Elements')]"), "elementsButton");


    public MainPage() {
        super(By.className("banner-image"), "mainPage", false);
    }

    public static void getToMP() {
        BrowserUtils.navigateToURL("https://demoqa.com/");
    }

    public void clickElements() {
        waits.waitForToBeClickable(elementsButton).click();
    }

    public void clickAlertsFrameWindows() {
        waits.waitForToBeClickable(alertsFrameButton).click();
    }

}


