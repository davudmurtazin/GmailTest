package com.epam.owntask.step;

import com.epam.owntask.page.ThemesPage;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Created by Davud_Murtazin on 1/6/2017.
 */
public class ThemesPageSteps extends AbstractSteps {
    private ThemesPage themesPage;

    public ThemesPageSteps(WebDriver driver) {
        super(driver);
        themesPage = new ThemesPage(driver);
    }

    public ThemesPageSteps setTheme(){
        log.info("Setting theme");
        themesPage.setTheme();
        return this;
    }

    public ThemesPageSteps enterMyPictures(){
        log.info("Enter my pictures");
        themesPage.enterMyPictures();
        return this;
    }

    public ThemesPageSteps enterUploadPicture(String fileName, double fileSize){
        log.info("Enter my pictures");
        themesPage.enterUploadPicture(fileName, fileSize);
        return this;
    }

    public boolean isWrongFileFormat(){
        log.info("Check file format");
        return themesPage.isWrongFileFormat();
    }

    public boolean setBeachTheme(){
        log.info("Check beach theme");
        return themesPage.setBeachTheme();
    }
}
