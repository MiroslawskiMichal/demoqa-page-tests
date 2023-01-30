package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {

    private Button tabButton=new Button(By.id("tabButton"), "New Tab Button");

    public BrowserWindowsPage() {
        super(By.id("tabButton"), "Browser Windows", true);
    }

    public void clickNewTab() {
        waits.waitForToBeClickable(tabButton).click();
    }

}
