package pages.side_menu;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;

public class CommonSideMainMenu extends BaseForm {
    private Button elementsMainMenuBtn;
    private Button alertsFrameWindowsMainMenuBtn;

    public CommonSideMainMenu() {
        super(By.className("left-pannel"), "common side menu", false);
        elementsMainMenuBtn = new Button(By.xpath("//*[@class='header-text' and contains(text(),'Elements')]"), "elements btn on main menu level");
        alertsFrameWindowsMainMenuBtn = new Button(By.xpath("//*[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]"), "alerts frame windows on main menu level");
    }

    public void clickElementsOnMainMenu() {
        waits.waitForToBeClickable(elementsMainMenuBtn).click();
    }

    public void clickAlertFrameWindowsOnMainMenu() {
        waits.waitForToBeClickable(alertsFrameWindowsMainMenuBtn).click();
    }


}
