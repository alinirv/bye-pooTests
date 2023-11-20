package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationOfDropoutPage {
    protected WebDriver webDriver;

    private By nameBy = By.id("txtName");
    private By identifyBy = By.id("txtId");
    private By reasonBy = By.id("txtReason");

    private By buttonRegistration = By.id("registrationFormSubmitButton");
    private By buttonList = By.id("bt2");



    public void SignInPageDropout(WebDriver webDriver){
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Bye Poo")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
    }



}
