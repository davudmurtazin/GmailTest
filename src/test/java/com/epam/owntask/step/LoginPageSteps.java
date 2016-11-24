package com.epam.owntask.step;

import com.epam.owntask.page.LoginPage;
import com.epam.owntask.property.PropertyProvider;
import com.epam.owntask.step.exception.StepsException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class LoginPageSteps extends AbstractSteps{
    private LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public LoginPageSteps openLoginPage() {
        log.info("opening login page");
        driver.get(PropertyProvider.getProperty("url"));
        return this;
    }

    public MainPageSteps authorization(String login, String password) {
        log.info("try to login in");
        try {
            loginPage.authorization(login, password);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return new MainPageSteps(driver);
    }
}
