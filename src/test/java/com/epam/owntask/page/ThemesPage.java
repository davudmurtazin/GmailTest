package com.epam.owntask.page;

import com.epam.owntask.util.FileUtil;
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

    @FindBy(xpath = "//div[contains(text(),'My Photos')]")
    private WebElement buttonYourPictures;

    @FindBy(xpath = "//div[@id=':7']/div")
    private WebElement buttonUploadPicture;

    @FindBy(xpath = "//div[@id=':t.select-files-button']/div")
    private WebElement buttonUploadFromComputer;

    @FindBy(xpath = "//div[@class='Dm-Gs-ic Dm-Hs-Md Dm-mx-Hs']/div[@aria-live='polite']")
    private WebElement textErrorMessage;

    @FindBy(xpath = "//iframe[@class='KA-JQ']")
    private WebElement frameThemeAdding;

    @FindBy(xpath = "//div[@bgid='custom-1']/img")
    private WebElement imgBeach;

    private RobotUtil robotUtil;

    public ThemesPage(WebDriver driver) {
        super(driver);
        robotUtil = new RobotUtil();
    }

    public void setTheme(){
        buttonSetTheme.click();
    }

    public void enterMyPictures(){
        wait.waitForElementIsClickable(buttonYourPictures).click();
        wait.waitForElementIsClickable(frameThemeAdding);
        driver.switchTo().frame(frameThemeAdding);
    }

    public void enterUploadPicture(String fileName, double fileSize){
        wait.waitForElementIsClickable(buttonUploadPicture).click();
        wait.waitForElementIsClickable(buttonUploadFromComputer).click();
        switchUtil.switchWindow();
        String filePath = FileUtil.createFile(fileName, fileSize);
        robotUtil.enterPathByRobot(filePath);
        switchUtil.switchWindow();
    }

    public boolean isWrongFileFormat(){
        return wait.waitForElementIsClickable(textErrorMessage).isEnabled();
    }

    public boolean setBeachTheme(){
        if(imgBeach.isEnabled()){
            imgBeach.click();
            return true;
        }else {
            return false;
        }
    }
}
