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
import org.testng.asserts.SoftAssert;

import java.awt.datatransfer.StringSelection;

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
    protected SoftAssert softAssert;
    protected static String TRASH_PAGE_TITLE = "in:trash";
    protected static String SPAM_PAGE_TITLE = "in:spam";
    protected static final String MESSAGE_TEXT = "It sent by automated test!";
    protected static final String FILE_PATH = "C:/Users/Davud_Murtazin/Downloads/SpaghettiTests.xlsx";

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginPage = new LoginPageSteps(driver);
        softAssert = new SoftAssert();
        user1 = new User(PropertyProvider.getProperty("login_user1"),PropertyProvider.getProperty("password_user1"));
        user2 = new User(PropertyProvider.getProperty("login_user2"),PropertyProvider.getProperty("password_user2"));
        user3 = new User(PropertyProvider.getProperty("login_user3"),PropertyProvider.getProperty("password_user3"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
    }
}