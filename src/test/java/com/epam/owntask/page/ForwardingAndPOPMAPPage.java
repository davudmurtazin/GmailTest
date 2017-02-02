package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class ForwardingAndPOPMAPPage extends AbstractPage {
    @FindBy(xpath = "//table[@class='cf']/descendant::input[@act = 'add']")
    private WebElement buttonAddForwardAddress;

    @FindBy(xpath = "//div[@class='Kj-JD-Jz']/div/input")
    private WebElement inputForwardAddress;

    @FindBy(xpath = "//button[@class='J-at1-auR']")
    private WebElement buttonNext;

    @FindBy(xpath = "//div[@class='nH Tv1JD']/descendant-or-self::tr[@class='r7'][position()=1]/descendant-or-self::td[@class='C6']/input")
    private WebElement checkBoxForwardCopyTo;

    @FindBy(xpath = "//div[@class='nH Tv1JD']/descendant-or-self::button[@guidedhelpid='save_changes_button']")
    private WebElement buttonSaveChanges;

    public ForwardingAndPOPMAPPage(WebDriver driver) {
        super(driver);
    }

    public void addForward(User user) {
        buttonAddForwardAddress.click();
        inputForwardAddress.sendKeys(user.getLogin());
        buttonNext.click();
    }

    public void forwardCopyTo(){
        wait.waitForElementIsClickable(checkBoxForwardCopyTo).click();
        wait.waitForElementIsClickable(buttonSaveChanges).click();
    }
}
