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
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
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
        Assertions.assertFalse(editPage.getId().getText().isEmpty(), "Não existe aluno");
    }
    @Test
    @DisplayName("Should Edit Dropout Information")
    void Shouldeditdropoutinformation() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editDropoutInformation(driver);

        final var confirmationMessage = editDropoutsPage.getEditConfirmationMessage().getText();
        assertThat(confirmationMessage).isEqualTo("Edição bem-sucedida");
    }
    /*@Test
    @DisplayName("Should Fail to Edit Dropout Information Without Name")
    void shouldFailToEditDropoutInformationWithoutName() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editDropoutInformation(driver, "", "newId","newReason");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("O nome do estudante deve ser fornecido.");
    }
    @Test
    @DisplayName("Should Fail to Edit Dropout Information Without Id")
    void shouldFailToEditDropoutInformationWithoutId() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editDropoutInformation(driver, "newName", "","newReason");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("O Id do estudante deve ser fornecido.");
    }
    @Test
    @DisplayName("Should Fail to Edit Dropout Information Without Reason")
    void shouldFailToEditDropoutInformationWithoutReason() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editDropoutInformation(driver, "NovoNome", "newId","");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("O motivo da desistência deve ser fornecido.");
    }
    @Test
    @DisplayName("Should Fail to Edit Dropout Information With Duplicate Identification")
    void shouldFailToEditDropoutInformationWithDuplicateIdentification() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editDropoutInformation(driver, "NovoNome", "NovoMotivo", "SC0000001");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("Já existe um desistente com o id SC0000001");
    }*/
}
