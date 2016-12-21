package com.epam.owntask.test;

import com.epam.owntask.driver.FactoryDriver;
import com.epam.owntask.page.*;
import com.epam.owntask.step.LoginPageSteps;
import com.epam.owntask.step.MainPageSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public abstract class BaseTest {
    protected MainPageSteps mainPage;
    protected LoginPageSteps loginPage;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginPage = new LoginPageSteps(driver);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
//        this.driver = null;
//        this.loginPage = null;
    }
}