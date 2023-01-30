package pages.side_menu;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;

public class ElementsWindowsSideMenu extends BaseForm {

    private Button linksBtn;
    private Button webTablesBtn;

    public ElementsWindowsSideMenu() {
        super(By.xpath("//*[@class='header-text' and contains(text(),'Elements')]"), "elements sisde menu", false);
        linksBtn = new Button(By.xpath("//span[contains(text(), 'Links')]"), "links on submenu");
        webTablesBtn = new Button(By.xpath("//span[contains(text(), 'Web Tables')]"), "web tables on submenu");
   }

    public  void clickLinks() {
        waits.waitForToBeClickable(linksBtn).click();
    }
    public  void clickWebTables() {
        waits.waitForToBeClickable(webTablesBtn).click();
    }
}
