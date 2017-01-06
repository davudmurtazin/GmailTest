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

    public ThemesPageSteps setTheme(String filePath){
        log.info("Setting theme");
        try {
            themesPage.setTheme(filePath);
        } catch (AWTException e) {
            log.info(e.getMessage());
        }
        return this;
    }

    public boolean isWrongFileFormat(){
        log.info("Check file format");
        return themesPage.isWrongFileFormat();
    }
}
