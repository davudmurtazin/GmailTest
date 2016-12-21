package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.MainPage;
import org.openqa.selenium.WebDriver;

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
        log.info("---Write message to user2---");
        if( message.isEmpty() ){
            log.info("Wrong params!");
        }
        mainPage.sendMessage(user,message);
        return this;
    }

    public MainPageSteps markMessageAsSpam(User user){
        log.info("---Mark message as spam---");
        mainPage.markMessageAsSpam(user);
        return this;
    }

    public SpamPageSteps enterToSpamPage(String pageTitle){
        log.info("Enter to page by title");
        if(pageTitle.isEmpty()){
            log.info("Wrong params!");
        }
        mainPage.enterToSpamPage(pageTitle);
        return new SpamPageSteps(driver);
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
        mainPage.enterToSettingsPage();
        return new SettingsPageSteps(driver);
    }
}
