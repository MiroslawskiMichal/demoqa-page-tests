package utils;

import driver.Singleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsUtilities {


    private final static WebDriverWait alertWait = Singleton.getWaits().getWait();
    public static String alertLastInput;
    private static Alert alert = Singleton.getDriver().switchTo().alert();

    public static String getAlertText() {
        alertWait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public static void clickAlertButton() {
        alertWait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static boolean isAlertPresent() {
        try {
            Singleton.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void sendKeysToAlert(String s) {
        if (isAlertPresent() == true) {
            alertLastInput = s;
            alert.sendKeys(alertLastInput);
            alert.accept();

        } else Logger.warningConsole("Alert wasn't visible to send keys");
    }

}
