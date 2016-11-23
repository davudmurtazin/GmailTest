package com.epam.owntask.page;

import com.epam.owntask.property.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class LoginPage extends AbstractPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Email")
    private WebElement loginNameField;
    @FindBy(css = "#next")
    private WebElement loginEnterButton;

    @FindBy(css = "#Passwd")
    private WebElement passwordField;
    @FindBy(css = "#signIn")
    private WebElement submitButton;



    public void authorization(String login, String password) throws InterruptedException {
        loginNameField.sendKeys(login);
        loginEnterButton.click();
        Thread.sleep(1000);
        passwordField.sendKeys(password);
        submitButton.click();
        Thread.sleep(6000);
    }

    public void openLoginPage(){
        log.info("opening login page");
        driver.get(PropertyProvider.getProperty("url"));
    }
}
