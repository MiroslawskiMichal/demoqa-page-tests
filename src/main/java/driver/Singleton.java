package driver;

import org.openqa.selenium.WebDriver;
import utils.FileReader;
import utils.Logger;

import java.io.File;

public class Singleton {


    private static WebDriver driver = null;
    private static Waits waits = null;

    private Singleton() {
        driver = BrowserFactory.createInstance();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            return driver = BrowserFactory.createInstance();
        }
        return driver;

    }

    public static Waits getWaits() {
        if (waits == null) {
            waits = (Waits) FileReader.mapJSONToObject(new File("waitSetting.json"), Waits.class);
            Logger.infoConsole(waits.toString());
        }
        return waits;
    }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }


}