package driver;

import models.DriverSettings;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.FileReader;
import utils.Logger;

import java.io.File;

public class BrowserCapabilities {

    public static DriverSettings getDriverSettings() {
        File file = new File("driverSettings.json");
        // return (DriverSettings) FileReader.jsonFileToObject(file, DriverSettings.class);
        return FileReader.mapJSONToObject(file, DriverSettings.class);
    }

    public static Capabilities getCapabilities() {
        DriverSettings ds = getDriverSettings();
        Logger.infoConsole(ds.toString());

        if (ds.getBrowserType().equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (ds.getIncognito() == true) {
                chromeOptions.addArguments("--incognito");
            }
            if (ds.getEngLanguage() == true) {
                chromeOptions.addArguments("--lang=eng");
            }
            if (ds.getStartMaximized() == true) {
                chromeOptions.addArguments("start-maximized");
            }
            return chromeOptions;
        }

        if (ds.getBrowserType().equals("firefox")) {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (ds.getIncognito() == true) {
                firefoxOptions.addArguments("-private");
            }
            if (ds.getEngLanguage() == true) {
                firefoxProfile.setPreference("intl.accept_languages", "eng");
            }
            return firefoxOptions.setProfile(firefoxProfile);
        }

        return null;


    }

}
