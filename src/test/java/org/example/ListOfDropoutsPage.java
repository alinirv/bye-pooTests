package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListOfDropoutsPage {
    private WebDriver driver;

    public ListOfDropoutsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openListPage() {
        driver.get("http://localhost:3000/Desistentes");
    }


    public List<WebElement> getStudentRows() {
        return driver.findElements(By.cssSelector(".StudentRow_StudentRow__JhSrj"));
    }
    public String getStudentId(WebElement studentRow) {
        return studentRow.findElement(By.cssSelector("td:nth-child(1)")).getText();
    }


    public String getStudentName(WebElement studentRow) {
        return studentRow.findElement(By.cssSelector("td:nth-child(2)")).getText();
    }


    public String getStudentReason(WebElement studentRow) {
        return studentRow.findElement(By.cssSelector("td:nth-child(3)")).getText();
    }

    public void deleteStudent(WebElement studentRow){
        studentRow.findElement(By.cssSelector("svg:nth-child(2)")).click();
    }

    public boolean isStudentDeletedById(String studentId) {
        List<WebElement> updatedStudentRows = getStudentRows();
        return updatedStudentRows.stream()
                .noneMatch(row -> row.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(studentId));

    }

}
