package base;

import driver.Singleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import utils.Logger;

public class BaseTest {

    public static MainPage mainPage;
    public static WebDriver driver = Singleton.getDriver();

    @BeforeMethod
    public static void setupMainPage() {
        MainPage.getToMP();
        mainPage = new MainPage();
        Logger.infoConsole("main page set up");
        Assert.assertTrue(mainPage.isPageOpened(), "Main page didnt load");
        Logger.infoConsole("main page loaded");
    }

    @AfterTest
    public static void closeAll() {
        Logger.infoConsole("driver will be closed");
        driver.quit();
    }

}
