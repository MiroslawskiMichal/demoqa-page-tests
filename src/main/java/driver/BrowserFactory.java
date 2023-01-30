package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {


    public static WebDriver createInstance() {
        WebDriver driver = null;

        if (BrowserCapabilities.getDriverSettings().getBrowserType().equals("chrome")) {
            return driver = WebDriverManager.chromedriver().capabilities(BrowserCapabilities.getCapabilities()).create();
        }
        if (BrowserCapabilities.getDriverSettings().getBrowserType().equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().capabilities(BrowserCapabilities.getCapabilities()).create();

            if (BrowserCapabilities.getDriverSettings().getStartMaximized() ==true) {
                driver.manage().window().maximize();
            }
            return driver;
        }
        return null;


    }
}