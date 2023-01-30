package base;

import driver.Singleton;
import driver.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Logger;

public class BaseForm {

    public String formName;
    public Waits waits;
    public WebDriver driver = Singleton.getDriver();
    private By uniqueFormLocator;
    private BaseElement uniqueElement;
    private BaseElement header;
    private boolean isContainingHeader;


    public BaseForm(By uniqueFormLocator, String formName, boolean isContainingHeader) {
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;
        uniqueElement = new BaseElement(uniqueFormLocator, "uniqueElement");
        waits = Singleton.getWaits();
        if (isContainingHeader == true) {
            header = new BaseElement(By.className("main-header"), "header");
        } else header = null;
    }

    public boolean isPageOpened() {
        return waits.waitForDisplayed(uniqueElement).isDisplayed();
    }

    public boolean verifyHeader() {
        if (isContainingHeader == true) {
            return waits.waitForDisplayed(header).getText().equals(formName);
        } else

            Logger.warningConsole(formName + " this page has no header");
        return false;
    }


}
