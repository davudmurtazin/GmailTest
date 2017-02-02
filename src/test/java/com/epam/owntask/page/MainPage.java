package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.step.LoginPageSteps;
import com.epam.owntask.util.FileUtil;
import com.epam.owntask.util.RobotUtil;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class MainPage extends AbstractPage{
    //select message and move it to spam
    @FindBy(xpath = "//div[@class = 'G-tF']//div[@aria-label='Move to']")
    private WebElement selectMoveTo;

    @FindBy(xpath = "//div[@id=':1i4']/div")
    private WebElement caseMoveToSpam;

    //enter to page by title--------------
    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputPageTitleToSearch;

    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement buttonEnterToPage;

    //write message---------------------
    @FindBy(xpath = "//div[@class ='z0']/div")
    private WebElement buttonWriteNewMessage;

    @FindBy(xpath="//div[@class = 'wO nr l1']/textarea")
    private WebElement inputLoginToSend;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement inputSubject;

    @FindBy(xpath="//div[@class='Am Al editable LW-avf']")
    private WebElement inputMessageText;

    @FindBy(xpath = "//td[@class = 'gU Up']/div/div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSendMessage;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement buttonAddAttachment;

    @FindBy(xpath = "//div[@class='HyIydd']")
    private WebElement linkIsBigFile;

    @FindBy(xpath = "//div[@class='QT aaA aMZ']")
    private WebElement buttonEmoticons;

    @FindBy(xpath = "//button[@class='a8v a8t a8t']")
    private WebElement buttonMoreEmoticons;

    @FindAll(@FindBy(xpath = "//div[@class='a8I']/div[1]/button"))
    private List<WebElement> allEmoticons;

    // logout---------------------
    @FindBy(xpath = "//a[@class = 'gb_b gb_db gb_R']/span")
    private WebElement iconLogout;

    @FindBy(xpath = "//a[@id='gb_71']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement linkLoginNewUser;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement buttonNewUser;

    //enter to settings page---------------
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']/div/preceding-sibling::div")
    private WebElement iconSettings;

    @FindBy(xpath = "//div[@class='J-M asi aYO jQjAxd']/descendant-or-self::div[@class='J-N aMS']/div")
    private WebElement selectSettings;

    @FindAll(@FindBy(xpath = "//table[@class='F cf zt']/descendant-or-self::div[@class='yW']/span[@email = 'forwarding-noreply@google.com']"))
    private List<WebElement> allMessagesFromGmail;

    private RobotUtil robotUtil;

    public MainPage(WebDriver driver) {
        super(driver);
        robotUtil = new RobotUtil();
    }

    public void enterToSpamPage(String pageTitle){
        inputPageTitleToSearch.sendKeys(pageTitle);
        buttonEnterToPage.click();
    }

    public void enterToSettingsPage(){
        wait.waitForElementIsClickable(iconSettings).click();
        wait.waitForElementIsClickable(selectSettings).click();
    }

    public void enterToTrashPage(String pageTitle){
        inputPageTitleToSearch.sendKeys(pageTitle);
        buttonEnterToPage.click();
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
        wait.waitForElementIsClickable(inputMessageText).sendKeys(message);
        buttonSendMessage.click();
    }

    public void sendMessageWithEmotion(User user, int countOfEmotions){
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        buttonEmoticons.click();
        buttonMoreEmoticons.click();
        driver.switchTo().activeElement();
        robotUtil.addEmoticonsByRobot(allEmoticons, countOfEmotions, wait);
        wait.waitForElementIsClickable(buttonSendMessage).click();
    }

    public void sendMessageWithAttachment(User user, String message, String fileName, double fileSize){
        String currentWindow = driver.getWindowHandle();
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        inputMessageText.sendKeys(message);
        buttonAddAttachment.click();
        switchUtil.switchWindow();
        String filePath = FileUtil.createFile(fileName, fileSize);
        robotUtil.enterPathByRobot(filePath);
        driver.switchTo().window(currentWindow);
        wait.waitForElementIsClickable(inputSubject).sendKeys(message);
        wait.waitForElementIsClickable(buttonSendMessage).click();
    }

    public boolean sendMessageWithBigFile(User user, String message, String fileName, double fileSize){
        String currentWindow = driver.getWindowHandle();
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        wait.waitForElementIsClickable(inputMessageText).sendKeys(message);
        buttonAddAttachment.click();
        switchUtil.switchWindow();
        String filePath = FileUtil.createFile(fileName, fileSize);
        //This thread sleep is for creating file(takes a lot of time)
        ThreadSleep.waitElement(5000);
        robotUtil.enterPathByRobot(filePath);
        driver.switchTo().window(currentWindow);
        FileUtil.deleteFile(filePath);
        return wait.waitForElementIsClickable(linkIsBigFile).isEnabled();
    }

    public LoginPageSteps logOutAfterLogInOneUser(){
        wait.waitForElementIsClickable(iconLogout).click();
        wait.waitForElementIsClickable(buttonLogout).click();
        linkLoginNewUser.click();
        buttonNewUser.click();
        return new LoginPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInSeveralUsers(){
        wait.waitForElementIsClickable(iconLogout).click();
        wait.waitForElementIsClickable(buttonLogout).click();
        wait.waitForElementIsClickable(buttonNewUser).click();
        return new LoginPageSteps(driver);
    }

    public MessagePage openConfirmForwardMessage(){
        wait.waitForElementIsClickable(allMessagesFromGmail.get(0)).click();
        return new MessagePage(driver);
    }

    public boolean hasMessageWithoutAttachmentInInbox(User user){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class= 'F cf zt']/descendant-or-self::span[@email = '"+user.getLogin()+"']"));
        return elements.isEmpty();
    }

    public void openLastMessage(User user){
        driver.navigate().refresh();
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='F cf zt']/descendant-or-self::div[@class='yW']/span[@email = '"+user.getLogin()+"']"));
        wait.waitForElementIsClickable(elements.get(0)).click();
    }
}
