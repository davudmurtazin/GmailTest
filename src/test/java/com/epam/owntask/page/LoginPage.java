package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.property.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public MainPage authorization(User user){
        loginNameField.sendKeys(user.getLogin());
        loginEnterButton.click();
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
        return new MainPage(driver);
    }
}
