package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.Duration;

public class ListOfDropoutsTest {

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private WebDriver driver;

    @Nested
    @DisplayName("testListScreen")
    public class TestListScreen{
        @Test
        void shouldOpenListPageTest(){
            driver.get("http://localhost:3000/Desistentes");
        }
    }




}
