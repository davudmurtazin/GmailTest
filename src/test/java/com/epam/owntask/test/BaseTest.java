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
    protected static String TRASH_PAGE_TITLE;
    protected static String SPAM_PAGE_TITLE;
    protected static String MESSAGE_TEXT;
    protected static String FILE_NAME;
    protected static double BIG_FILE_SIZE;
    protected static double SMALL_FILE_SIZE;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginPage = new LoginPageSteps(driver);
        softAssert = new SoftAssert();
        user1 = new User(PropertyProvider.getProperty("login_user1"),PropertyProvider.getProperty("password_user1"));
        user2 = new User(PropertyProvider.getProperty("login_user2"),PropertyProvider.getProperty("password_user2"));
        user3 = new User(PropertyProvider.getProperty("login_user3"),PropertyProvider.getProperty("password_user3"));
        TRASH_PAGE_TITLE = PropertyProvider.getProperty("trash_page_title");
        SPAM_PAGE_TITLE = PropertyProvider.getProperty("spam_page_title");
        MESSAGE_TEXT = PropertyProvider.getProperty("message_text");
        FILE_NAME = PropertyProvider.getProperty("file_name");
        BIG_FILE_SIZE = Double.parseDouble(PropertyProvider.getProperty("big_file_size"));
        SMALL_FILE_SIZE = Double.parseDouble(PropertyProvider.getProperty("small_file_size"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
    }
}