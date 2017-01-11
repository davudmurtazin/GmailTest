package com.epam.owntask.page;

import com.epam.owntask.util.RobotUtil;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

/**
 * Created by Davud_Murtazin on 1/6/2017.
 */
public class ThemesPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='e NvzLyc']")
    private WebElement buttonSetTheme;

    @FindBy(xpath = "//div[@class='Kj-JD-Jl a8Y']/div[4]")
    private WebElement buttonYourPictures;

    @FindBy(xpath = "//div[@class='a-Qh a-Qh-w']/div")
    private WebElement buttonUploadPicture;

    @FindBy(xpath = "//div[@class='Dm-Xx-py Dm-Xx-ty']/div[4]/div")
    private WebElement buttonUploadFromComputer;

    @FindBy(xpath = "//div[@class='Dm-Fs-ic Dm-Gs-Md Dm-lx-Gs']/div[4]")
    private WebElement textErrorMessage;

    public ThemesPage(WebDriver driver) {
        super(driver);
    }

    public void setTheme(String filePath) throws AWTException {
        buttonSetTheme.click();
        wait.waitForElementIsClickable(buttonYourPictures).click();
        wait.waitForElementIsClickable(buttonUploadPicture).click();
        buttonUploadFromComputer.click();
        String currentWindow = driver.getWindowHandle();
        switchUtil.switchWindow();
        ThreadSleep.waitElement(4000);
        RobotUtil robotUtil = new RobotUtil(new Robot());
        robotUtil.enterPathByRobot(filePath);
        ThreadSleep.waitElement(4000);
        driver.switchTo().window(currentWindow);
    }

    public boolean isWrongFileFormat(){
        return wait.waitForElementIsClickable(textErrorMessage).isEnabled();
    }
}
