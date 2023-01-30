import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import pages.forms.RegistrationForm;
import pages.side_menu.AlertsFrameWindowsSideMenu;
import pages.side_menu.CommonSideMainMenu;
import pages.side_menu.ElementsWindowsSideMenu;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DemoQaWebsiteTests extends BaseTest {

    @DataProvider(name = "webtables_test")
    public static Object[][] setUpPolicyPageData() throws IOException {
        List<User> userList = FileReader.jsonFileToArrayUsers(new File("usersData.json"));
        return new Object[][]{
                new Object[]{userList.get(1)}
        };
    }

    @Test
    public static void alertsTest() {
        Logger.infoConsole("===alerts test====");
        mainPage.clickAlertsFrameWindows();
        AlertsFrameWindowsSideMenu alertsFrameWindowsSideMenu = new AlertsFrameWindowsSideMenu();
        alertsFrameWindowsSideMenu.clickAlerts();

        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isPageOpened(), "Alerts Page didn;t load");
        Logger.infoConsole("Alerts Page loaded");

        alertsPage.clickOpenNewAlert();
        Assert.assertEquals(AlertsUtilities.getAlertText(), "You clicked a button", "Alert text doesnt match");
        Logger.infoConsole("Alert opened, text as expected");

        AlertsUtilities.clickAlertButton();
        Assert.assertFalse(AlertsUtilities.isAlertPresent(), "alert is still present");
        Logger.infoConsole("Alert closed as expected");

        alertsPage.clickOpenNewConfirmBox();
        Assert.assertEquals(AlertsUtilities.getAlertText(), "Do you confirm action?", "Alert text doesnt match");
        Logger.infoConsole("Alert opened, text as expected");

        AlertsUtilities.clickAlertButton();
        Assert.assertFalse(AlertsUtilities.isAlertPresent(), "alert is still present");
        Logger.infoConsole("Alert opened, text as expected");
        Assert.assertEquals(alertsPage.getConfirmRestultText(), "You selected Ok", "Alert text doesnt match");
        Logger.infoConsole("Alert confirmation text as expected");

        alertsPage.clickOpenNewPromptBox();
        Assert.assertEquals(AlertsUtilities.getAlertText(), "Please enter your name", "Alert text doesnt match");
        Logger.infoConsole("Prompt box opened as expected");

        String randString = RandomUtilities.generateRandomString();
        AlertsUtilities.sendKeysToAlert(randString);
        Assert.assertFalse(AlertsUtilities.isAlertPresent());
        Logger.infoConsole("Alert closed as expected");
        Assert.assertEquals(AlertsUtilities.alertLastInput, randString, "input string doesn't equal ");
        Logger.infoConsole("Appeared text equals rand imput");
    }

    @Test
    public static void iframeTest() {
        Logger.infoConsole("===iframe test====");
        mainPage.clickAlertsFrameWindows();

        AlertsFrameWindowsSideMenu alertsFrameWindowsSideMenu = new AlertsFrameWindowsSideMenu();
        alertsFrameWindowsSideMenu.clickNestedFrames();

        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpened(), "Nested Frames Page didn;t load");
        Logger.infoConsole("opened nested frames page");

        Assert.assertTrue(nestedFramesPage.areFramesTextsVisible(), "one of expected messages in frames isn't visible");
        Logger.infoConsole("expected texts are visible in frames");

        BrowserUtils.switchToDefaultContent();
        alertsFrameWindowsSideMenu.clickFrames();

        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpened(), "Frames page didn't open");
        Logger.infoConsole("opened frames page");

        Assert.assertTrue(framesPage.areFramesTextsMatching(), "Texts in frames are different");
        Logger.infoConsole("text in frames as expected");
    }

    @Test(dataProvider = "webtables_test")
    public static void tablesTest(User testUser) {
        Logger.infoConsole("===webtables test====");

        mainPage.clickElements();

        ElementsWindowsSideMenu elementsWindowsSideMenu = new ElementsWindowsSideMenu();
        elementsWindowsSideMenu.clickWebTables();

        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isPageOpened(), "Web tables page didn;t load");

        webTablesPage.clickAddBtn();

        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isPageOpened(), "Form isn't displayed");

        registrationForm.submitForm(testUser);

        webTablesPage = new WebTablesPage();
        webTablesPage.getRecordsList();


        int webTablesRecordsSizeWithAddedRec = webTablesPage.getRecordsListSize();

        Assert.assertTrue(StringUtilities.containsWords(webTablesPage.getRecordText(webTablesPage.getLastRecordId()), testUser.getUserDetails()), "there is problem with added record");
        Logger.infoConsole("record added as expected, matching given data");

        webTablesPage.deleteRecord(webTablesRecordsSizeWithAddedRec);

        webTablesPage.getRecordsList();
        Logger.infoConsole("webtable refreshed");

        Assert.assertFalse(webTablesRecordsSizeWithAddedRec == webTablesPage.getRecordsListSize(), "number of records didn't change");
        Logger.infoConsole("record deleted");

        Assert.assertFalse(StringUtilities.containsWords(webTablesPage.getRecordText(webTablesPage.getLastRecordId()), testUser.getUserDetails()), "there is problem with record deletion");
        Logger.infoConsole("data of added user deleted from table");
    }

    @Test
    public static void handlesTest() {
        Logger.infoConsole("===handles test====");
        mainPage.clickAlertsFrameWindows();

        AlertsFrameWindowsSideMenu alertsFrameWindowsSideMenu = new AlertsFrameWindowsSideMenu();
        alertsFrameWindowsSideMenu.clickBrowserWindows();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();

        Assert.assertTrue(browserWindowsPage.isPageOpened(), "Browser Windows Page didn;t load");
        Logger.infoConsole("Browser Windows page loaded");

        browserWindowsPage.clickNewTab();
        Assert.assertTrue(BrowserUtils.getNewTabURL().contains("sample"), "New tab isn't sample page");
        Logger.infoConsole("opened sample page");

        BrowserUtils.closeNewTab();
        Logger.infoConsole("closed sample page");
        Assert.assertTrue(browserWindowsPage.isPageOpened(), "Browser Windows Page didn;t load");

        CommonSideMainMenu commonSideMainMenu = new CommonSideMainMenu();
        commonSideMainMenu.clickElementsOnMainMenu();

        ElementsWindowsSideMenu elementsWindowsSideMenu = new ElementsWindowsSideMenu();
        elementsWindowsSideMenu.clickLinks();

        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpened(), "Links Page didn;t load");
        Logger.infoConsole("opened links page");

        linksPage.clickHomeLink();

        BrowserUtils.getNewTab();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page didnt load");
        Logger.infoConsole("opened main page");

        BrowserUtils.getFirstTab();
        Assert.assertTrue(linksPage.isPageOpened(), "Links page didnt load");
    }

}
