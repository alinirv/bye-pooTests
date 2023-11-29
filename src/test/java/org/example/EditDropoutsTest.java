package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EditDropoutsTest {
    private WebDriver driver;

    private EditDropoutsPage editPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        editPage = new EditDropoutsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void shouldOpenEditPageTest() throws InterruptedException{
        driver.get("http://localhost:3000/Desistentes");
        List<WebElement> rows = editPage.getStudentRows();
        Assertions.assertFalse(rows.isEmpty(), "Lista vazia");
        editPage.clikEditStudent(rows.get(2));
        Assertions.assertTrue(editPage.getId().getText().isEmpty(), "Não existe aluno");
    }

    @Test
    @DisplayName("Should Fail to Edit Dropout Information Change Name")
    void shouldFailToEditDropoutInformationChangeName() throws InterruptedException {
        driver.get("http://localhost:3000/Desistentes");
        List<WebElement> rows = editPage.getStudentRows();
        Assertions.assertFalse(rows.isEmpty(), "Lista vazia");
        WebElement rowSelect = rows.get(2);
        String nameStudent = String.valueOf(editPage.getName());
        String idStudent = String.valueOf(editPage.getId());
        editPage.clikEditStudent(rowSelect);
        editPage.editName();
        boolean isNameModify = editPage.isStudentNameUpdatedById(idStudent, nameStudent) ;
        assertThat(isNameModify).isFalse();
    }
}
