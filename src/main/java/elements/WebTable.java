package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTable extends BaseElement {

    private List<WebElement> recordsList;

    public WebTable(By locator, String name) {
        super(locator, name);
    }

    public void getRecordsList(By locator) {
        this.recordsList = driver.findElements(locator);
    }

    public String getLastRecord() {
        return recordsList.get(recordsList.size() - 1).getText();
    }

    public int getRecordsListSize() {
        return recordsList.size();
    }

    public String getRecordText(int id) {
        return recordsList.get(id).getText();
    }

}
