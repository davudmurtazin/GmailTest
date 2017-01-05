package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.datatransfer.StringSelection;
import java.util.List;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class MainPageSteps extends AbstractSteps{
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
    }

    public MainPageSteps sendMessage(User user, String message){
        log.info("Write message without attachment");
        if( message.isEmpty() ){
            log.info("Wrong params!");
        }
        mainPage.sendMessage(user,message);
        return this;
    }

    public MainPageSteps sendMessageWithAttachment(User user, String message, String filePath){
        log.info("Write message with attachment");
        if( message.isEmpty()){
            log.info("Wrong params!");
        }
        mainPage.sendMessageWithAttachment(user, message, filePath);
        return this;
    }

    public boolean sendMessageWithBigFile(User user, String message){
        log.info("Write message with attaching big file");
        if( message.isEmpty()){
            log.info("Wrong params!");
        }
        return mainPage.sendMessageWithBigFile(user, message);
    }

    public MainPageSteps markMessageAsSpam(User user){
        log.info("Mark message as spam");
        mainPage.markMessageAsSpam(user);
        return this;
    }

    public SpamPageSteps enterToSpamPage(String pageTitle){
        log.info("Enter to spam page");
        if(pageTitle.isEmpty()){
            log.info("Wrong params!");
        }
        mainPage.enterToSpamPage(pageTitle);
        return new SpamPageSteps(driver);
    }

    public TrashPageSteps enterToTrashPage(String pageTitle){
        log.info("Enter to trash page");
        if(pageTitle.isEmpty()){
            log.info("Wrong params!");
        }
        mainPage.enterToTrashPage(pageTitle);
        return new TrashPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInOneUser(){
        log.info("Log out after log in one user");
        mainPage.logOutAfterLogInOneUser();
        return new LoginPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInSeveralUsers(){
        log.info("Log out after log in several users");
        mainPage.logOutAfterLogInSeveralUsers();
        return new LoginPageSteps(driver);
    }

    public SettingsPageSteps enterToSettingsPage(){
        log.info("Enter to setting page");
        mainPage.enterToSettingsPage();
        return new SettingsPageSteps(driver);
    }

    public MessagePageSteps openConfirmForwardMessage(){
        log.info("Open confirm formard message");
        mainPage.openConfirmForwardMessage();
        return new MessagePageSteps(driver);
    }

    public boolean hasMessageWithoutAttachmentInInbox(User user){
        log.info("Checking message without attachment in inbox");
        return mainPage.hasMessageWithoutAttachmentInInbox(user);
    }
}
