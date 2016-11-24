package com.epam.owntask.step;

import com.epam.owntask.page.LoginPage;
import com.epam.owntask.page.MainPage;
import com.epam.owntask.page.SpamPage;
import com.epam.owntask.step.exception.StepsException;
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

    public MainPageSteps writeMessage(String loginUser2, String message){
        log.info("---Write message to user2---");
        if(loginUser2.isEmpty() || message.isEmpty() ){
            new StepsException("Wrong params!");
        }
        try {
            mainPage.writeMessage(loginUser2,message);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return this;
    }

    public MainPageSteps markMessageAsSpam(){
        log.info("---Mark message as spam---");
        try {
            mainPage.markMessageAsSpam();
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return this;
    }

    public SpamPageSteps enterToSpamPage(String pageTitle){
        log.info("Enter to page by title");
        if(pageTitle.isEmpty()){
            new StepsException("Wrong params!");
        }
        try {
            mainPage.enterToSpamPage(pageTitle);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
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
}
