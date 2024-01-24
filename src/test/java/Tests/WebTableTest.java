package Tests;

import Base.BaseTest;
import Pages.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTableTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        webTablesPage = new WebTablesPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @Test(priority = 10)
    public void userCanAddDataInTable() {

        int numeberOfRows = driver.findElements(By.className("mr-2")).size();
        int counterOfOccupiedCells = numeberOfRows * 7;
        int maxCounterOfFilledCells = ((excelReader.getLastRow("WebTables") - 1) * 7) + counterOfOccupiedCells;
        int i = 1;

        while (counterOfOccupiedCells < maxCounterOfFilledCells) {
            webTablesPage.clickOnAddButton();
            String firstName = excelReader.getStringData("WebTables", i, 0);
            webTablesPage.inputFistName(firstName);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            webTablesPage.inputLastName(lastName);
            String email = excelReader.getStringData("WebTables", i, 2);
            webTablesPage.inputEmail(email);
            String age = String.valueOf(excelReader.getIntegerData("WebTables", i, 3));
            webTablesPage.inputAge(age);
            String salary = String.valueOf(excelReader.getIntegerData("WebTables", i, 4));
            webTablesPage.inputSalary(salary);
            String department = excelReader.getStringData("WebTables", i, 5);
            webTablesPage.inputDepartment(department);
            webTablesPage.clickOnSubmitButton();

            // Assert se odnosi na prvu stranicu, tj. ne vrsi se assert za ostale stranice
            if (counterOfOccupiedCells < 70) {
                wait.until(ExpectedConditions.textToBePresentInElement(webTablesPage.cell.get(counterOfOccupiedCells), firstName));
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells).getText(), firstName);
                wait.until(ExpectedConditions.textToBePresentInElement(webTablesPage.cell.get(counterOfOccupiedCells + 1), lastName));
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells + 1).getText(), lastName);
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells + 2).getText(), age);
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells + 3).getText(), email);
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells + 4).getText(), salary);
                Assert.assertEquals(webTablesPage.cell.get(counterOfOccupiedCells + 5).getText(), department);
            }
            // Na counter se dodaje 7 jer ima 7 kolona i tako se prelazi na prvo polje seldeceg reda
            counterOfOccupiedCells += 7;
            i++;
        }
    }
}
