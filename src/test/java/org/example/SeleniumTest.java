package org.example;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {


    @Test
    @DisplayName("Should open and close firefox browser")
    void shouldOpenAndCloseChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver","src/test/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(1000);
        driver.quit();
    }
}
