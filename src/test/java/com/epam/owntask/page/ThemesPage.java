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

    @FindBy(xpath = "//div[@class='Dm-Fs-Zb-Qh-Yb-ho']/div/div[3]/div")
    private WebElement buttonUploadPicture;

    @FindBy(xpath = "//div[@class='Dm-Yx-qy Dm-Yx-uy']/div[4]/div")
    private WebElement buttonUploadFromComputer;

    @FindBy(xpath = "//div[@class='Dm-Gs-ic Dm-Hs-Md Dm-mx-Hs']/div[4]")
    private WebElement textErrorMessage;

    @FindBy(xpath = "//iframe[@class='KA-JQ']")
    private WebElement frameThemeAdding;

    @FindBy(xpath = "//div[@bgid='custom-10']/div[2]")
    private WebElement imgBeach;

    public ThemesPage(WebDriver driver) {
        super(driver);
    }

    public void setTheme(){
        buttonSetTheme.click();
        ThreadSleep.waitElement(1000);
    }

    public void enterMyPictures(){
        wait.waitForElementIsClickable(buttonYourPictures).click();
        wait.waitForElementIsClickable(frameThemeAdding);
        driver.switchTo().frame(frameThemeAdding);
    }

    public void enterUploadPicture(String filePath){
        wait.waitForElementIsClickable(buttonUploadPicture).click();
        wait.waitForElementIsClickable(buttonUploadFromComputer).click();
        switchUtil.switchWindow();
        ThreadSleep.waitElement(4000);
        try {
            RobotUtil robotUtil = new RobotUtil(new Robot());
            robotUtil.enterPathByRobot(filePath);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        ThreadSleep.waitElement(4000);
        switchUtil.switchWindow();
    }

    public boolean isWrongFileFormat(){
        return wait.waitForElementIsClickable(textErrorMessage).isEnabled();
    }

    public boolean couldSetBeachTheme(){
        if(imgBeach.isEnabled()){
            imgBeach.click();
            return true;
        }else {
            return false;
        }
    }


}
