package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "userEmail")
    public WebElement email;
    @FindBy(id = "age")
    public WebElement age;
    @FindBy(id = "salary")
    public WebElement salary;
    @FindBy(id = "department")
    public WebElement department;
    @FindBy(id = "submit")
    public WebElement submit;
    @FindBy(className = "rt-td")
    public List<WebElement> cell;

    //----------------------------
    public void clickOnAddButton(){
        addButton.click();
    }
    public void inputFistName(String name){
        firstName.clear();
        firstName.sendKeys(name);
    }
    public void inputLastName(String last){
        lastName.clear();
        lastName.sendKeys(last);
    }
    public void inputEmail(String mail){
        email.clear();
        email.sendKeys(mail);
    }
    public void inputAge(String a){
        age.clear();
        age.sendKeys(a);
    }
    public void inputSalary(String s){
        salary.clear();
        salary.sendKeys(s);
    }
    public void inputDepartment(String d){
        department.clear();
        department.sendKeys(d);
    }
    public void clickOnSubmitButton(){
        submit.click();
    }
}
