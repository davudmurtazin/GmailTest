package com.epam.owntask.test;

import com.epam.owntask.property.PropertyProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class ShouldAddForwardTest extends BaseTest{
    
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        this.loginPage.openLoginPage();
        mainPage = loginPage.authorization(user2);
    }

    @Test
    public void testShouldAddMessageWithAttachToTrash(){
        softAssert.assertFalse(mainPage.enterToSettingsPage()
                .enterToForwardingAndPOPMAPPage()
                .addForward(user3)
                .continueAddingForward()
                .logOutAfterLogInOneUser()
                .authorization(user3)
                .openConfirmForwardMessage()
                .confirmRequestForward()
                .logOutAfterLogInSeveralUsers()
                .authorization(user2)
                .enterToSettingsPage()
                .enterToForwardingAndPOPMAPPage()
                .forwardIncomingMessage()
                .enterToSettingsPage()
                .enterToFiltersPage()
                .createNewFilter(user1,user2)
                .logOutAfterLogInSeveralUsers()
                .authorization(user1)
                .sendMessageWithAttachment(user2, MESSAGE_TEXT, FILE_NAME, SMALL_FILE_SIZE)
                .sendMessage(user2,MESSAGE_TEXT)
                .logOutAfterLogInSeveralUsers()
                .authorization(user2)
                .enterToTrashPage(TRASH_PAGE_TITLE)
                .hasAnyMessageWithAttachment(user1));
        softAssert.assertFalse(mainPage.hasMessageWithoutAttachmentInInbox(user1));
        softAssert.assertFalse(mainPage.hasMessageWithoutAttachmentInInbox(user3));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}