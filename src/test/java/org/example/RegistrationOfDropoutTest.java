package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationOfDropoutTest {
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    private WebDriver driver;
    @Test
    void shouldOpenRegisterPageTest() throws InterruptedException{
        driver.get("http://localhost:3000/");
        Thread.sleep(1000);
    }

    @Test
    void shouldCheckIfAreOnTheCorrectPage() throws InterruptedException{
        driver.get("http://localhost:3000/");
        RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
        final var titlePage = registrationOfDropoutPage.getTitlePage().getText();
        assertThat(titlePage).isEqualTo("Registro De Desistentes");
        Thread.sleep(1000);
    }


    @Test
    @DisplayName("Should Fill Out Dropout Page and Register")
    void shouldFillOutDropoutPageAndRegister() throws InterruptedException{
        driver.get("http://localhost:3000/");
        RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
        Thread.sleep(3000);
        registrationOfDropoutPage.FillOutDropoutPage(driver);
        final var modalParagraph = registrationOfDropoutPage.getParam().getText();
        assertThat(modalParagraph).isEqualTo("Arregou");
    }

    @Test
    @DisplayName("Should Fill Out Dropout Page Without Name")
    void shouldFillOutDropoutPageWithoutName() throws  InterruptedException{
        driver.get("http://localhost:3000/");
        RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
        Thread.sleep(3000);
        registrationOfDropoutPage.FillOutDropoutPageWithoutName(driver);
        final var msg = registrationOfDropoutPage.getMsgError().getText();
        assertThat(msg).isEqualTo("O nome do estudante deve ser fornecido.");
    }

    @Test
    @DisplayName("Should Fill Out Dropout Page With Duplicate Identification")
    void shouldFillOutDropoutPageWithDuplicateIdentification() throws  InterruptedException{
        driver.get("http://localhost:3000/");
        RegistrationOfDropoutPage registrationOfDropoutPage = new RegistrationOfDropoutPage(driver);
        Thread.sleep(3000);
        registrationOfDropoutPage.FillOutDropoutPageWithDuplicateIdentification(driver);
        final var msg = registrationOfDropoutPage.getMsgError().getText();
        assertThat(msg).isEqualTo("Já existe um desistente com o id SC3297857");
    }


}
