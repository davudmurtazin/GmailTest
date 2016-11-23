package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class WriteMessagePage extends AbstractPage{
    @FindBy(xpath = "//div[@class ='z0']/div")
    private WebElement writeNewMessage;
    @FindBy(xpath=".//textarea[@id=':nl']")
    private WebElement enterToLogin;
    @FindBy(xpath=".//div[@id=':ob']")
    private WebElement messageText;
    @FindBy(xpath = "//div[@id=':mv']")
    private WebElement sendMessage;
    @FindBy(xpath = "//span[contains(text(),'Просмотреть сообщение')]")
    private WebElement accessSent;

    public WriteMessagePage(WebDriver driver) {
        super(driver);
    }

    public boolean writeMessage(String login, String message) throws InterruptedException {
        log.info("write Message To User2");
        writeNewMessage.click();
        Thread.sleep(1000);
        enterToLogin.sendKeys(login);
        messageText.sendKeys(message);
        Thread.sleep(2000);
        sendMessage.click();
        if(accessSent.isEnabled()){
            return true;
        }
        else return false;
    }
}
