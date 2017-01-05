package com.epam.owntask.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Davud_Murtazin on 1/5/2017.
 */
public class ShouldAttachBigFile extends BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        mainPage = loginPage.authorization(user1);
    }

    @Test
    public void testShouldAttachBigFile() throws Exception {
        softAssert.assertFalse(mainPage.sendMessageWithBigFile(user1, MESSAGE_TEXT));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }

}