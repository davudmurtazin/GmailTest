package com.epam.owntask.page;

import com.epam.owntask.property.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/23/2016.
 */
public class MarkMessageAsSpamPage extends AbstractPage {
    @FindBy(xpath = "//table[@id=':3m']/tbody/tr[1]/td[2]/div/div")
    private WebElement selectMessage;
    @FindBy(xpath = "//div[@class = 'G-tF']/div[3]/div[1]")
    private WebElement moveTo;

    @FindBy(xpath = "//div[contains(@class, 'J-N-Jz') and text()='Спам']")
    private WebElement toSpam;

    @FindBy(xpath = "//span[contains(text(),'Цепочка отмечена как спам.')]")
    private WebElement accessMovedToSpamPackage;
    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputSpamPageToSearch;
    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement submitSpamPage;
    @FindBy(xpath = "//span[contains(text(),'Удалить все письма со спамом')]")
    private WebElement accessOpenSpamPage;




    public MarkMessageAsSpamPage(WebDriver driver) {
        super(driver);
    }
    public boolean markMessageAsSpam(){
        selectMessage.click();
        try {
            Thread.sleep(1000);
            moveTo.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        toSpam.click();

        if(accessMovedToSpamPackage.isEnabled()){
            return true;
        }else {
            return false;
        }
    }

    public boolean markAsSpam(LoginPage loginPage, LogoutPage logoutPage, WriteMessagePage writeMessagePage,
                              String login_user1, String password_user1, String login_user2,
                              String password_user2, String message, String spam_page){
        try {
            Thread.sleep(1000);
            logoutPage.logout();
            loginPage.authorization(login_user2, password_user2);
            markMessageAsSpam();
            Thread.sleep(1000);
            logoutPage.logoutSecond();
            Thread.sleep(3000);
            System.out.println(login_user1+password_user1);
            loginPage.authorization(login_user1, password_user1);
            writeMessagePage.writeMessage(login_user2, message);
            logoutPage.logoutSecond();
            loginPage.authorization(login_user2, password_user2);
            inputSpamPageToSearch.sendKeys(spam_page);
            submitSpamPage.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(accessOpenSpamPage.isEnabled()){
            return true;
        }else{
            return false;
        }
    }
}
