package elements;

import base.BaseElement;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void type(String s) {
        findElement().sendKeys(s);
    }

    public void clear() {
        findElement().clear();
    }


}
