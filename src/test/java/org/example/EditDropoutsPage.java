package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

public class EditDropoutsPage {

    protected WebDriver webDriver;
    Faker faker = new Faker(new Locale("pt-BR"));

    @FindBy(id = "txtName")
    private WebElement nameBy;

    @FindBy(id = "txtId")
    private WebElement idBy;
    @FindBy(id = "txtReason")
    private WebElement reasonBy;

    @FindBy(id = "registrationFormSubmitButton")
    private WebElement buttonRegistration;

    @FindBy(xpath = "//div[@id='editConfirmation']/p")
    private WebElement editConfirmationMessage;

    @FindBy(xpath = "//div[@id='errorMessageBox']/p")
    private WebElement errorMessageBox;

    public EditDropoutsPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editDropoutInformation(WebDriver driver) {
        String name = String.valueOf(faker.name().fullName());
        String identify = "SC0000003";
        nameBy.sendKeys(name);
        idBy.sendKeys(identify);

        Select select = new Select(reasonBy);
        List<WebElement> optionList = select.getOptions();
        select.selectByValue("Não estava muito bem");

        buttonRegistration.click();
    }
    public WebElement getEditConfirmationMessage() {

        return editConfirmationMessage;
    }
    public WebElement getErrorMessageBox() {
        return errorMessageBox;
    }
    public void clikEditStudent(WebElement studentRow){
        studentRow.findElement(By.cssSelector("svg:nth-child(1)")).click();
    }
    public WebElement getId(){
        return idBy;
    }
    public WebElement getName(){
        return nameBy;
    }
    public WebElement getReason(){
        return reasonBy;
    }

    public List<WebElement> getStudentRows() {
        return webDriver.findElements(By.cssSelector(".StudentRow_StudentRow__JhSrj"));
    }
}





