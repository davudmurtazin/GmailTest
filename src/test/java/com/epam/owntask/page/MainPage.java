package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.step.LoginPageSteps;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    // logout---------------------
    @FindBy(xpath = "//a[@class = 'gb_b gb_db gb_R']/span")
    private WebElement iconLogout;

    @FindBy(xpath = "//a[text() = 'Выйти']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement linkLoginNewUser;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement buttonNewUser;

    //enter to settings page---------------
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']/div[1]")
    private WebElement iconSettings;

    @FindBy(xpath = "//div[@class='SK AX']/div[8]/div")
    private WebElement selectSettings;

    //confirm forward--------------------------
    @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr[1]/td[4]/div[2]/span")
    private WebElement linkOpenMessage;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterToSpamPage(String title){
        inputSpamPageToSearch.sendKeys(title);
        submitSpamPage.click();
    }

    public void enterToSettingsPage(){
        iconSettings.click();
        selectSettings.click();
    }

    public void markMessageAsSpam(User user){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class= 'F cf zt']/descendant-or-self::span[@email = '"+user.getLogin()+"']/parent::div/parent::td/preceding-sibling::td[@class='oZ-x3 xY']/div/div"));
        wait.waitForElementIsClickable(elements.get(0)).click();
        for (WebElement element: elements) {
            System.out.println(element.getText());
        }

        wait.waitForElementIsClickable(selectMoveTo).click();
        caseMoveToSpam.click();
    }

    public void sendMessage(User user, String message){
        buttonWriteNewMessage.click();
        inputLoginToSend.sendKeys(user.getLogin());
        inputMessageText.sendKeys(message);
        buttonSendMessage.click();
    }

    public LoginPageSteps logOutAfterLogInOneUser(){
        iconLogout.click();
        ThreadSleep.waitElement(1000);
        buttonLogout.click();
        linkLoginNewUser.click();
        buttonNewUser.click();
        return new LoginPageSteps(driver);
    }

    public LoginPageSteps logOutAfterLogInSeveralUsers(){
        iconLogout.click();
        ThreadSleep.waitElement(1000);
        buttonLogout.click();
        buttonNewUser.click();
        return new LoginPageSteps(driver);
    }


}
