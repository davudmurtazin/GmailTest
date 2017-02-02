package com.epam.owntask.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 1/13/2017.
 */
public class ShouldAddExistingTheme extends BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        mainPage = loginPage.authorization(user1);
    }

    @Test
    public void testShouldAddExistingTheme() throws Exception {
        softAssert.assertFalse(mainPage.enterToSettingsPage()
                .enterToThemesPage()
                .setTheme()
                .setBeachTheme());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
