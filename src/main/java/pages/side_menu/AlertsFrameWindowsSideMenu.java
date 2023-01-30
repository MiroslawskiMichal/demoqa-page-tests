package pages.side_menu;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;

public class AlertsFrameWindowsSideMenu extends BaseForm {
    private Button browserWindowsBtn;
    private Button alertsBtn;
    private Button nestedFramesBtn;
    private Button framesBtn;


    public AlertsFrameWindowsSideMenu() {
        super(By.xpath("//*[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]"), "Alerts Frame Windows side menu", false);
        browserWindowsBtn = new Button(By.xpath("//span[contains(text(), 'Browser Windows')]"), "browser windows on submenu");
        alertsBtn = new Button(By.xpath("//span[contains(text(), 'Alerts')]"), "alerts button on submenu");
        nestedFramesBtn = new Button(By.xpath("//span[contains(text(), 'Nested Frames')]"), "nested frames on submenu");
        framesBtn = new Button(By.xpath("//span[contains(text(), 'Frames')]"), "frames on submenu");
    }


    public void clickFrames() {
        waits.waitForToBeClickable(framesBtn).click();
    }

    public void clickNestedFrames() {
        waits.waitForToBeClickable(nestedFramesBtn).click();

    }

    public void clickBrowserWindows() {
        waits.waitForToBeClickable(browserWindowsBtn).click();
    }

    public void clickAlerts() {
        waits.waitForToBeClickable(alertsBtn).click();

    }


}
