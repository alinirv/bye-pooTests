package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/h3")
    private WebElement titlePage;

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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/p")
    private WebElement msgError;

    //@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div")
    private By modalSucessBy = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div");

    public WebElement getParam() {
        return param;
    }

    public WebElement getMsgError() {
        return msgError;
    }

    public WebElement getTitlePage() { return titlePage ;}

    public By getModalSucessBy() { return modalSucessBy; }

    public RegistrationOfDropoutPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }


    public void FillOutDropoutPage(WebDriver driver){
        String name = String.valueOf(faker.name().fullName());
        String identify = "SC" + faker.numerify("#######");

        nameBy.sendKeys(name);
        identifyBy.sendKeys(identify);
        Select select = new Select(reasonBy);
        List<WebElement> optionList = select.getOptions();
        select.selectByValue("Não estava muito bem");

        buttonRegistration.click();
    }

    public void FillOutDropoutPageWithoutName(WebDriver driver){

        String identify = "SC" + faker.numerify("#######");
        identifyBy.sendKeys(identify);

        Select select = new Select(reasonBy);
        List<WebElement> optionList = select.getOptions();
        select.selectByValue("Outra");

        buttonRegistration.click();
    }

    public void FillOutDropoutPageWithDuplicateIdentification(WebDriver driver){
        String name = String.valueOf(faker.name().fullName());
        nameBy.sendKeys(name);

        String identify = "SC0000001";
        identifyBy.sendKeys(identify);

        Select select = new Select(reasonBy);
        List<WebElement> optionList = select.getOptions();
        select.selectByValue("Não estava muito bem");

        buttonRegistration.click();
    }


}
