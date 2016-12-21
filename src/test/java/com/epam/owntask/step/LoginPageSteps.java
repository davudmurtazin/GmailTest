package com.epam.owntask.step;

import com.epam.owntask.page.LoginPage;
import com.epam.owntask.property.PropertyProvider;
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
        log.info("Opening login page");
        driver.get(PropertyProvider.getProperty("url"));
        return this;
    }

    public MainPageSteps authorization(String login, String password) {
        log.info("Authorization");
        try {
            loginPage.authorization(login, password);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
        return new MainPageSteps(driver);
    }
}
