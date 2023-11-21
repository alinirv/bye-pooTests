package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;


public class RegistrationOfDropoutPage{
    protected WebDriver webDriver;
    Faker faker = new Faker(new Locale("pt-BR"));
    @FindBy(id="txtName")
    private WebElement nameBy;

    @FindBy(id="txtId")
    private WebElement identifyBy;

    @FindBy(id="txtReason")
    private WebElement reasonBy;

    @FindBy(id="registrationFormSubmitButton")
    private WebElement buttonRegistration;

    @FindBy(id="bt2")
    private WebElement buttonList;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/p")
    private WebElement param;

    public WebElement getParam() {
        return param;
    }

    public RegistrationOfDropoutPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SignInPageDropout(WebDriver webDriver){
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Bye Poo")) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
    }

    public void FillOutDropoutPage(WebDriver driver){
        String name = String.valueOf(faker.name().fullName());
        String identify = "SC" + faker.numerify("#######");

        nameBy.sendKeys(name);
        identifyBy.sendKeys(identify);
        Select select = new Select(reasonBy);
        List<WebElement> optionList = select.getOptions();
        select.selectByValue("Arreguei");

        buttonRegistration.click();
    }


}
