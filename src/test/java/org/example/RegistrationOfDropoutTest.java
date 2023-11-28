package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegistrationOfDropoutTest {
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    private WebDriver driver;

    @Nested
    @DisplayName("testRegistrationScreen")
    class TestRegistrationScreen{
        @Test
        void shouldOpenRegisterPageTest() throws InterruptedException{
            driver.get("http://localhost:3000/");
        }

        @Test
        void shouldCheckIfAreOnTheCorrectPage() throws InterruptedException{
            driver.get("http://localhost:3000/");
            RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
            final var titlePage = registrationOfDropoutPage.getTitlePage().getText();
            assertThat(titlePage).isEqualTo("Registro De Desistentes");
        }


        @Test
        @DisplayName("Should Fill Out Dropout Page and Register")
        void shouldFillOutDropoutPageAndRegister() throws InterruptedException{
            driver.get("http://localhost:3000/");
            RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
            registrationOfDropoutPage.FillOutDropoutPage(driver);
            final var modalParagraph = registrationOfDropoutPage.getParam().getText();
            assertNotNull(String.valueOf(registrationOfDropoutPage.getModalSucessBy()));
        }

        @Test
        @DisplayName("Should Fill Out Dropout Page Without Name")
        void shouldFillOutDropoutPageWithoutName() throws  InterruptedException{
            driver.get("http://localhost:3000/");
            RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
            registrationOfDropoutPage.FillOutDropoutPageWithoutName(driver);
            final var msg = registrationOfDropoutPage.getMsgError().getText();
            assertThat(msg).isEqualTo("O nome do estudante deve ser fornecido.");
        }

        @Test
        @DisplayName("Should Fill Out Dropout Page With Duplicate Identification")
        void shouldFillOutDropoutPageWithDuplicateIdentification() throws  InterruptedException{
            driver.get("http://localhost:3000/");
            RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
            registrationOfDropoutPage.FillOutDropoutPageWithDuplicateIdentification(driver);
            final var msg = registrationOfDropoutPage.getMsgError().getText();
            assertThat(msg).isEqualTo("Já existe um desistente com o id SC0000001");
        }
    }


}
