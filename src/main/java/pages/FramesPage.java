package pages;

import base.BaseForm;
import driver.Singleton;
import org.openqa.selenium.By;
import utils.BrowserUtils;

public class FramesPage extends BaseForm {

    public FramesPage() {
        super(By.id("framesWrapper"), "Frames", true);
    }

    public String getFrametext(By locator) {

        BrowserUtils.getFrame(locator);
        String frameText = Singleton.getDriver().findElement(By.tagName("body")).getText();

        BrowserUtils.switchToDefaultContent();
        return frameText;
    }


    public boolean areFramesTextsMatching() {
        if (getFrametext(By.id("frame1")).equals(getFrametext(By.id("frame2")))) {
            return true;
        }
        return false;
    }


}
