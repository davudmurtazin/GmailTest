package com.epam.owntask.test;

import com.epam.owntask.driver.FactoryDriver;
import com.epam.owntask.entity.User;
import com.epam.owntask.page.*;
import com.epam.owntask.property.PropertyProvider;
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
    protected User user1;
    protected User user2;
    protected User user3;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginPage = new LoginPageSteps(driver);
        user1 = new User(PropertyProvider.getProperty("login_user1"),PropertyProvider.getProperty("password_user1"));
        user2 = new User(PropertyProvider.getProperty("login_user2"),PropertyProvider.getProperty("password_user2"));
        user3 = new User(PropertyProvider.getProperty("login_user3"),PropertyProvider.getProperty("password_user3"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
    }
}