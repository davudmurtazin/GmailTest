package com.epam.owntask.page;

import com.epam.owntask.property.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class LoginPage extends AbstractPage{
    //user name
    @FindBy(css = "#Email")
    private WebElement loginNameField;
    @FindBy(css = "#next")
    private WebElement loginEnterButton;

    //password
    @FindBy(css = "#Passwd")
    private WebElement passwordField;
    @FindBy(css = "#signIn")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage authorization(String login, String password) throws InterruptedException {
        loginNameField.sendKeys(login);
        loginEnterButton.click();
        Thread.sleep(1000);
        passwordField.sendKeys(password);
        submitButton.click();
        Thread.sleep(4000);
        return new MainPage(driver);
    }

    public void openLoginPage(){
        driver.get(PropertyProvider.getProperty("url"));
    }
}
