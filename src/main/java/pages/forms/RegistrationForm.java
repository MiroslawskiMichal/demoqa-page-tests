package pages.forms;

import base.BaseForm;
import elements.Button;
import elements.TextBox;
import models.User;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {
    private Button sumbmitBtn;
    private TextBox firstNameTxt;
    private TextBox lastNameTxt;
    private TextBox userEmailTxt;
    private TextBox ageTxt;
    private TextBox salaryTxt;
    private TextBox departmentTxt;

    public RegistrationForm() {
        super(By.id("registration-form-modal"), "registration form", false);
        sumbmitBtn = new Button(By.id("submit"), "submit button");
        firstNameTxt = new TextBox(By.id("firstName"), "first name input field");
        lastNameTxt = new TextBox(By.id("lastName"), "last name input field");
        userEmailTxt = new TextBox(By.id("userEmail"), "user email input field");
        ageTxt = new TextBox(By.id("age"), "age input field");
        salaryTxt = new TextBox(By.id("salary"), "salary input field");
        departmentTxt = new TextBox(By.id("department"), "department input field");
    }


    public void submitForm(User user) {

        waits.waitForAbleToSendKeys(firstNameTxt).type(user.getFirstName());
        waits.waitForAbleToSendKeys(lastNameTxt).type(user.getLastName());
        waits.waitForAbleToSendKeys(userEmailTxt).type(user.getEmail());
        waits.waitForAbleToSendKeys(ageTxt).type(user.getAge());
        waits.waitForAbleToSendKeys(salaryTxt).type(user.getSalary());
        waits.waitForAbleToSendKeys(departmentTxt).type(user.getDepartment());

        waits.waitForToBeClickable(sumbmitBtn).click();
    }


}
