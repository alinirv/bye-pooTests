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


}
