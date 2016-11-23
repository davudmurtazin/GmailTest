package com.epam.owntask.test;

import com.epam.owntask.driver.FactoryDriver;
import com.epam.owntask.page.LoginPage;
import com.epam.owntask.page.WriteMessagePage;
import com.epam.owntask.property.PropertyProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class ShouldMarkAsSpamTest extends BaseTest{
    private static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    private static final String PASSWORD_USER2 = PropertyProvider.getProperty("password_user2");
    private static String MESSAGE_TEXT = "It sent by automated test!=)";
    private static final String SPAM_PAGE = "in:spam";

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        loginPage.authorization(PropertyProvider.getProperty("login_user1"),
            PropertyProvider.getProperty("password_user1"));
        writeMessagePage.writeMessage(LOGIN_USER2,MESSAGE_TEXT);
    }

    @Test
    public void testMarkMessageAsSpam() throws Exception {
        Assert.assertTrue(markMessageAsSpamPage.markAsSpam(loginPage, logoutPage, writeMessagePage,PropertyProvider.getProperty("login_user1"),
                PropertyProvider.getProperty("password_user1"),PropertyProvider.getProperty("login_user2"),
                PropertyProvider.getProperty("password_user2"),MESSAGE_TEXT,SPAM_PAGE));
    }

    @Test

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}