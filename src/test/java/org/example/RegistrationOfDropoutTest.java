package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.RegistrationOfDropoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RegistrationOfDropoutTest {
    private WebDriver driver;
    @Test
    public void shouldOpenRegisterPageTest() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(1000);
        driver.quit();
    }

}
