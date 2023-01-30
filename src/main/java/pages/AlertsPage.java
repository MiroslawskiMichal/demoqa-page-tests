package pages;

import base.BaseForm;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {

    Button openNewAlertBtn = new Button(By.id("alertButton"), "new alert button");
    Button openConfirmBoxBtn = new Button(By.id("confirmButton"), "new confirm box button");
    ;

    Button openPromptBoxBtn = new Button(By.id("promtButton"), "new prompt box button");

    Label confirmResultLabel;

    public AlertsPage() {
        super(By.xpath("//div[contains(@class, 'main-header') and text() = 'Alerts']"), "Alerts", true);
    }

    public String getConfirmRestultText() {
        confirmResultLabel = new Label(By.id("confirmResult"), "confirm result label");
        return waits.waitForDisplayed(confirmResultLabel).getText();
    }

    public void clickOpenNewAlert() {
        waits.waitForToBeClickable(openNewAlertBtn).click();
    }

    public void clickOpenNewConfirmBox() {
        waits.waitForToBeClickable(openConfirmBoxBtn).click();
    }

    public void clickOpenNewPromptBox() {
        waits.waitForToBeClickable(openPromptBoxBtn).click();
    }

}
