package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.step.LoginPageSteps;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class MainPage extends AbstractPage{
    //select message and move it to spam
    @FindBy(xpath = "//div[@class = 'G-tF']/div[3]/div[1]")
    private WebElement selectMoveTo;

    @FindBy(xpath = "//div[@id=':1i4']/div")
    private WebElement caseMoveToSpam;

    //enter to page by title--------------
    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputSpamPageToSearch;

    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement submitSpamPage;

    //write message---------------------
    @FindBy(xpath = "//div[@class ='z0']/div")
    private WebElement buttonWriteNewMessage;

    @FindBy(xpath="//div[@class = 'wO nr l1']/textarea")
    private WebElement inputLoginToSend;

    @FindBy(xpath="//div[@class='Am Al editable LW-avf']")
    private WebElement inputMessageText;

    @FindBy(xpath = "//td[@class = 'gU Up']/div/div[2]")
    private WebElement buttonSendMessage;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement buttonAddAttachment;

    // logout---------------------
    @FindBy(xpath = "//a[@class = 'gb_b gb_db gb_R']/span")
    private WebElement iconLogout;

    @FindBy(xpath = "//div[@class='gb_xb']/div[2]/a")
    private WebElement buttonLogout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement linkLoginNewUser;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement buttonNewUser;

    //enter to settings page---------------
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']/div[1]")
    private WebElement iconSettings;

    @FindBy(xpath = "//div[@class='J-M asi aYO jQjAxd']/descendant-or-self::div[@class='J-N aMS']/div")
    private WebElement selectSettings;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterToSpamPage(String title){
        inputSpamPageToSearch.sendKeys(title);
        submitSpamPage.click();
    }

    public void enterToSettingsPage(){
        wait.waitForElementIsClickable(iconSettings).click();
        ThreadSleep.waitElement(1000);
        wait.waitForElementIsClickable(selectSettings).click();
    }

    public void enterToTrashPage(){

    }

    public void markMessageAsSpam(User user){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class= 'F cf zt']/descendant-or-self::span[@email = '"+user.getLogin()+"']/parent::div/parent::td/preceding-sibling::td[@class='oZ-x3 xY']/div/div"));
        wait.waitForElementIsClickable(elements.get(0)).click();

        wait.waitForElementIsClickable(selectMoveTo).click();
        caseMoveToSpam.click();
    }

    public void sendMessage(User user, String message){
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        inputMessageText.sendKeys(message);
        buttonSendMessage.click();
    }

    public void sendMessageWithAttachment(User user, String message, String filePath){
        String currentWindow = driver.getWindowHandle();
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        inputMessageText.sendKeys(message);
        buttonAddAttachment.click();
        switchUtil.switchWindow();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
        Robot robot = new Robot();
        for (char c : filePath.toCharArray()) {
            switch(c){
                case '.' :  robot.keyPress(KeyEvent.VK_PERIOD);
                            robot.keyRelease(KeyEvent.VK_PERIOD);break;
                case ':' :  robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_SEMICOLON);
                            robot.keyRelease(KeyEvent.VK_SEMICOLON);
                            robot.keyRelease(KeyEvent.VK_SHIFT); break;
                case '_' :  robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_MINUS);
                            robot.keyRelease(KeyEvent.VK_MINUS);
                            robot.keyRelease(KeyEvent.VK_SHIFT); break;
                default:    robot.keyPress(c);
                            robot.keyRelease(c); break;
            }
//            if (c != '.') {
//                robot.keyPress(c);
//                robot.keyRelease(c);
//            } else {
//                robot.keyPress(KeyEvent.VK_PERIOD);
//            }
        }

            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        ThreadSleep.waitElement(10000);
        driver.switchTo().window(currentWindow);
        wait.waitForElementIsClickable(buttonSendMessage).click();
    }

    public LoginPageSteps logOutAfterLogInOneUser(){
        ThreadSleep.waitElement(2000);
        iconLogout.click();
        ThreadSleep.waitElement(1000);
        buttonLogout.click();
        linkLoginNewUser.click();
        buttonNewUser.click();
        return new LoginPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInSeveralUsers(){
        wait.waitForElementIsClickable(iconLogout).click();
        ThreadSleep.waitElement(1000);
        buttonLogout.click();
        buttonNewUser.click();
        return new LoginPageSteps(driver);
    }

    public MessagePage openConfirmForwardMessage(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='F cf zt']/descendant-or-self::div[@class='yW']/span[@email = 'forwarding-noreply@google.com']"));
        wait.waitForElementIsClickable(elements.get(0)).click();
        return new MessagePage(driver);
    }
}
