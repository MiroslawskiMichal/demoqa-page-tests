package pages;

import base.BaseForm;
import driver.Singleton;
import org.openqa.selenium.By;
import utils.BrowserUtils;

public class NestedFramesPage extends BaseForm {

    public NestedFramesPage() {
        super(By.id("frame1Wrapper"), "Nested Frames", true);
    }


    public String getParentFrameText() {
        BrowserUtils.getFrame(By.id("frame1"));
        return Singleton.getDriver().findElement(By.tagName("body")).getText();
    }


    public String getChildFrameText() {
        Singleton.getDriver().switchTo().frame(0);
        return Singleton.getDriver().findElement(By.tagName("p")).getText();
    }


    public boolean areFramesTextsVisible() {
        if (getParentFrameText().equals("Parent frame") && getChildFrameText().equals("Child Iframe")) {
            return true;
        } else {
            return false;
        }
    }
}
