package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.Duration;
import java.util.List;

public class ListOfDropoutsTest {

    private WebDriver driver;
    private ListOfDropoutsPage listOfDropoutsPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        listOfDropoutsPage = new ListOfDropoutsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Nested
    @DisplayName("Teste da Página de Lista")
    public class TestListScreen {

        @Test
        @DisplayName("Deve abrir a página de lista  e verificar se há alunos cadastrados")
        void shouldOpenListPageAndVerifyStudents() {
            listOfDropoutsPage.openListPage();
            List<WebElement> studentRows = listOfDropoutsPage.getStudentRows();
            Assertions.assertFalse(studentRows.isEmpty(), "A lista de alunos está vazia.");
        }
    }

    @Test
    @DisplayName("Deve verificar se os detalhes do aluno são exibidos corretamente na lista")
    void shouldVerifyStudentDetailsInList() {
        listOfDropoutsPage.openListPage();
        List<WebElement> studentRows = listOfDropoutsPage.getStudentRows();
        WebElement firstStudent = studentRows.get(1);

        final var softly = new SoftAssertions();
        softly.assertThat(listOfDropoutsPage.getStudentId(firstStudent)).isEqualTo("SC0000001");
        softly.assertThat(listOfDropoutsPage.getStudentName(firstStudent)).isEqualTo("Alguem ae");
        softly.assertThat(listOfDropoutsPage.getStudentReason(firstStudent)).isEqualTo("O Prof. Lucas não vai pro céu");
        softly.assertAll();

    }

    @Test
    @DisplayName("Deleta um aluno e verifica se ele foi realmente deletado")
    public void deleteStudent() {
        listOfDropoutsPage.openListPage();

        List<WebElement> studentRows = listOfDropoutsPage.getStudentRows();

        Assertions.assertFalse(studentRows.isEmpty(), "A lista de alunos está vazia.");

        WebElement firstStudent = studentRows.get(2);

        String studentIdToDelete = listOfDropoutsPage.getStudentId(firstStudent);

        listOfDropoutsPage.deleteStudent(firstStudent);

        boolean isStudentDeleted = listOfDropoutsPage.isStudentDeletedById(studentIdToDelete);

        assertThat(isStudentDeleted).isTrue();
    }
}
