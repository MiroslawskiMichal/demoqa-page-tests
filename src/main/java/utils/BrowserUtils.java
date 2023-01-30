package utils;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    private final static WebDriverWait browserWait = Singleton.getWaits().getWait();
    private static WebDriver driver = Singleton.getDriver();

    public static String getNewTabTitle() {
        getNewTab();
        return driver.getTitle();
    }

    public static String getNewTabURL() {
        getNewTab();
        return driver.getCurrentUrl();
    }

    public static void getNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) Singleton.getDriver();
        if (getTabsHandlesList().size() > 1) {
            driver.switchTo().window(getTabsHandlesList().get(getTabsHandlesList().size() - 1));
            waitForPageToLoad();
        } else Logger.warningConsole("No new tab opened");
    }


    public static void closeNewTab() {
        if (getTabsHandlesList().size() > 1) {
            driver.switchTo().window(getTabsHandlesList().get(getTabsHandlesList().size() - 1));
            driver.close();
            getFirstTab();
        } else Logger.warningConsole("can't close new tab, there's only one tab");
    }

    public static void getFirstTab() {
        driver.switchTo().window(getTabsHandlesList().get(0));
    }

    private static List<String> getTabsHandlesList() {
        List<String> browserTabs;
        return browserTabs = new ArrayList<String>(driver.getWindowHandles());
    }


    public static void moveToElement(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) Singleton.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", e);
    }

    public static void navigateToURL(String url) {
        driver.get(url);
    }

    public static void getFrame(By locator) {
        WebElement frame = driver.findElement(locator);
        driver.switchTo().frame(frame);
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    private static void waitForPageToLoad() {
        browserWait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

}