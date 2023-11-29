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

    public void editName() {
        String name = String.valueOf(faker.name().fullName());
        nameBy.clear();
        nameBy.sendKeys(name);
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
    public String getStudentName(WebElement studentRow) {
        return studentRow.findElement(By.cssSelector("td:nth-child(2)")).getText();
    }
    // Método para verificar se o nome de um aluno foi alterado com base no ID
    public boolean isStudentNameUpdatedById(String studentId, String expectedName) {
        List<WebElement> updatedStudentRows = getStudentRows();

        // Procura a linha do aluno com o ID especificado
        WebElement studentRow = updatedStudentRows.stream()
                .filter(row -> row.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(studentId))
                .findFirst()
                .orElse(null);

        // Se a linha do aluno com o ID for encontrada, verifica se o nome foi alterado corretamente
        return studentRow != null && studentRow.findElement(By.cssSelector("td:nth-child(2)")).getText().equals(expectedName);
    }
    public boolean isErrorMessageDisplayedForNonExistentId() {
        String identify = "SC" + faker.numerify("#######");
        idBy.sendKeys(identify);
        // Substitua o seletor CSS pelo seletor real que corresponde à mensagem de erro
        By errorMessageSelector = By.cssSelector(".Notification_Notification__9HZmX p");

        List<WebElement> errorMessages = webDriver.findElements(errorMessageSelector);

        // Verifica se pelo menos uma mensagem de erro contém o texto esperado
        return errorMessages.stream()
                .anyMatch(errorMessage -> errorMessage.getText().contains("Não existe um desistente com id " + identify));
    }
}





