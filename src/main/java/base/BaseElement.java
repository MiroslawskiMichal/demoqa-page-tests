package base;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
    public final WebDriver driver = Singleton.getDriver();
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;

    }

    public WebElement findElement() {
        return driver.findElement(locator);
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed() {
        return driver.findElement(locator).isDisplayed();
    }

    public String getAttribute(String atribute) {
        return driver.findElement(locator).getAttribute(atribute);
    }

}
