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
    private static String SPAM_PAGE_TITLE = "in:spam";

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        mainPage = loginPage.authorization(user1);
        mainPage.sendMessage(user2,MESSAGE_TEXT);
    }

    @Test
    public void testMarkMessageAsSpam() throws Exception {
        Assert.assertTrue(mainPage.logOutAfterLogInOneUser()
                .authorization(user2)
                .markMessageAsSpam(user1)
                .logOutAfterLogInSeveralUsers()
                .authorization(user1)
                .sendMessage(user2,MESSAGE_TEXT)
                .logOutAfterLogInSeveralUsers()
                .authorization(user2)
                .enterToSpamPage(SPAM_PAGE_TITLE)
                .isSpamPage());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}