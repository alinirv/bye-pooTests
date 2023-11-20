package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class RegistrationOfDropoutPage{
    protected WebDriver webDriver;

    private By nameBy = By.id("txtName");
    private By identifyBy = By.id("txtId");
    private By reasonBy = By.id("txtReason");

    private By buttonRegistration = By.id("registrationFormSubmitButton");
    private By buttonList = By.id("bt2");

    public RegistrationOfDropoutPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SignInPageDropout(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriver.get("http://localhost:3000/");
        if (!webDriver.getTitle().equals("Bye Poo")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
    }



}
