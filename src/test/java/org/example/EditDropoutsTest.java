package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class EditDropoutsTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    @DisplayName("Should Edit Dropout Information")
    void Shouldeditdropoutinformation() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editarInformacoesDesistencias(driver, "NovoNome", "NovoMotivo");

        final var confirmationMessage = editDropoutsPage.getEditConfirmationMessage().getText();
        assertThat(confirmationMessage).isEqualTo("Edição bem-sucedida");
    }
    @Test
    @DisplayName("Should Fail to Edit Dropout Information Without Name")
    void shouldFailToEditDropoutInformationWithoutName() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editarInformacoesDesistencias(driver, "", "NovoMotivo");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("O nome do estudante deve ser fornecido.");
    }
    @Test
    @DisplayName("Should Fail to Edit Dropout Information Without Reason")
    void shouldFailToEditDropoutInformationWithoutReason() throws InterruptedException {
        driver.get("http://localhost:3000/");

        EditDropoutsPage editDropoutsPage = new EditDropoutsPage(driver);
        editDropoutsPage.editarInformacoesDesistencias(driver, "NovoNome", "");

        final var errorMessage = editDropoutsPage.getErrorMessageBox().getText();
        assertThat(errorMessage).isEqualTo("O motivo da desistência deve ser fornecido.");
    }
}
