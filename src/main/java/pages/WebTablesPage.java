package pages;

import base.BaseForm;
import elements.Button;
import elements.WebTable;
import org.openqa.selenium.By;

public class WebTablesPage extends BaseForm {

    private Button addNewRecordBtn = new Button(By.id("addNewRecordButton"), "Add new record button");
    private WebTable webTable = new WebTable(By.xpath("//div[@class='rt-table' and @role='grid']"), "main table");

    private Button deleteRecordBtn;

    public WebTablesPage() {
        super(By.xpath("//div[contains(@class, 'main-header') and text() = 'Web Tables']"), "Web Tables", true);
    }

    public void clickAddBtn() {
        waits.waitForToBeClickable(addNewRecordBtn).click();
    }

    public void deleteRecord(int id) {
        String s = "delete-record-" + id;
        deleteRecordBtn = new Button(By.id(s), "delete button for chosen record");
        waits.waitForToBeClickable(deleteRecordBtn).click();

    }

    public void getRecordsList() {
        webTable.getRecordsList(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
    }

    public int getLastRecordId() {
        return webTable.getRecordsListSize() - 1;
    }

    public int getRecordsListSize() {
        return webTable.getRecordsListSize();
    }

    public String getRecordText(int id) {
        return webTable.getRecordText(id);
    }

}
