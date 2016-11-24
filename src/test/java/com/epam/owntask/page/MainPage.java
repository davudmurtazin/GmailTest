package com.epam.owntask.page;

import com.epam.owntask.step.LoginPageSteps;
import com.epam.owntask.step.exception.StepsException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class MainPage extends AbstractPage{
    //select message and move it to spam
    @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr[1]/td[2]/div/div")
    private WebElement checkBoxSelectMessage;
    @FindBy(xpath = "//div[@class = 'G-tF']/div[3]/div[1]")
    private WebElement selectMoveTo;
    @FindBy(xpath = "//div[contains(@class, 'J-N-Jz') and text()='Спам']")
    private WebElement caseMoveToSpam;

    //enter to page by title
    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputSpamPageToSearch;
    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement submitSpamPage;

    //write message
    @FindBy(xpath = "//div[@class ='z0']/div")
    private WebElement buttonWriteNewMessage;
    @FindBy(xpath="//table[@class='GS']/tbody/tr/td[2]/div/div/textarea")
    private WebElement inputLoginToSend;
    @FindBy(xpath="//div[@class='Am Al editable LW-avf']")
    private WebElement inputMessageText;
    @FindBy(xpath = "//div[@class='aDh']/table/tbody/tr/td/div/div[2]")
    private WebElement buttonSendMessage;

    // logout
    @FindBy(xpath = "//a[@class = 'gb_b gb_db gb_R']/span")
    private WebElement iconLogout;
    @FindBy(xpath = "//a[text() = 'Выйти']")
    private WebElement buttonLogout;
    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement linkLoginNewUser;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement buttonNewUser;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterToSpamPage(String title) throws InterruptedException {
        log.info("---Enter to page by title---");
        inputSpamPageToSearch.sendKeys(title);
        submitSpamPage.click();
        Thread.sleep(1000);
    }

    public void markMessageAsSpam() throws InterruptedException {
        log.info("---Mark message as spam---");
        Thread.sleep(4000);
        checkBoxSelectMessage.click();
        try {
            Thread.sleep(1000);
            selectMoveTo.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        caseMoveToSpam.click();
    }

    public void writeMessage(String login, String message) throws InterruptedException {
        log.info("---Write message to user2---");
        buttonWriteNewMessage.click();
        Thread.sleep(1000);
        inputLoginToSend.sendKeys(login);
        inputMessageText.sendKeys(message);
        buttonSendMessage.click();
        Thread.sleep(2000);
    }

    public LoginPageSteps logOutAfterLogInOneUser(){
        try {
            iconLogout.click();
            buttonLogout.click();
            Thread.sleep(1000);
            linkLoginNewUser.click();
            Thread.sleep(1000);
            buttonNewUser.click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return new LoginPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInSeveralUsers(){
        try {
            iconLogout.click();
            Thread.sleep(2000);
            buttonLogout.click();
            Thread.sleep(1000);
            buttonNewUser.click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return new LoginPageSteps(driver);
    }
}
