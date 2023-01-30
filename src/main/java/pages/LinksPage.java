package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {

    private Button homeLinkBtn= new Button(By.linkText("Home"), "Homepage link button");;

    public LinksPage() {
        super(By.id("linkWrapper"), "Links", true);
    }

    public void clickHomeLink() {
        waits.waitForToBeClickable(homeLinkBtn).click();
    }


}
