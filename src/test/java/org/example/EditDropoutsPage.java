package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDropoutsPage {

    protected WebDriver webDriver;
    //verificar os nomes dos campos
    @FindBy(id = "txtEditedName")
    private WebElement editedNameBy;

    @FindBy(id = "txtEditedReason")
    private WebElement editedReasonBy;

    @FindBy(id = "btnSaveEdit")
    private WebElement saveEditButton;

    @FindBy(xpath = "//div[@id='editConfirmation']/p")
    private WebElement editConfirmationMessage;

    public EditDropoutsPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editarInformacoesDesistencias(WebDriver driver, String novoNome, String novoMotivo) {
        editedNameBy.clear();
        editedNameBy.sendKeys(novoNome);

        editedReasonBy.clear();
        editedReasonBy.sendKeys(novoMotivo);

        saveEditButton.click();
    }

    public WebElement getEditConfirmationMessage() {
        return editConfirmationMessage;
    }
}


