package com.epam.owntask.test;

import com.epam.owntask.property.PropertyProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class ShouldMarkAsSpamTest extends BaseTest{
    private static final String LOGIN_USER1 = PropertyProvider.getProperty("login_user1");
    private static final String PASSWORD_USER1 = PropertyProvider.getProperty("password_user1");
    private static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    private static final String PASSWORD_USER2 = PropertyProvider.getProperty("password_user2");
    private static String MESSAGE_TEXT = "It sent by automated test!=)";
    private static String SPAM_PAGE_TITLE = "in:spam";

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        mainPage = loginPage.authorization(LOGIN_USER1,PASSWORD_USER1);
        mainPage.writeMessage(LOGIN_USER2,MESSAGE_TEXT);
    }

    @Test
    public void testMarkMessageAsSpam() throws Exception {
        Assert.assertTrue(mainPage.logOutAfterLogInOneUser()
                .authorization(LOGIN_USER2, PASSWORD_USER2)
                .markMessageAsSpam()
                .logOutAfterLogInSeveralUsers()
                .authorization(LOGIN_USER1,PASSWORD_USER1)
                .writeMessage(LOGIN_USER2,MESSAGE_TEXT)
                .logOutAfterLogInSeveralUsers()
                .authorization(LOGIN_USER2, PASSWORD_USER2)
                .enterToSpamPage(SPAM_PAGE_TITLE)
                .isSpamPage());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}