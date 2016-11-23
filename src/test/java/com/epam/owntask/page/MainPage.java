package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a[text()='Списки']")
    private WebElement buttonLists;

    @FindBy(xpath = "//a[text() = 'Новый Пациент']")
    private WebElement newPatientButton;
    @FindBy(id = "LastName")
    private WebElement surNameSearchField;
    @FindBy(xpath = "//button[text() = 'Поиск']")
    private WebElement searchButton;
    @FindBy(xpath = "//td[text() = 'Давыдчик']")
    private WebElement resultSurName;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToNewPatientForm() {
        newPatientButton.click();
    }


    public void goToListsPage() {
        buttonLists.click();
    }

    public void insertSurNameIntoSearchField(String searchRequestSurName) {
        surNameSearchField.sendKeys(searchRequestSurName);
    }

    public void clickSubmitSearchButton() {
        searchButton.click();
    }

    public String getSearchResultBySurName() {
        return resultSurName.getText();

    }
}
