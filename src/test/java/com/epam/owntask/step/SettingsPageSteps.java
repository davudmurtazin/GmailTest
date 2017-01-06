package com.epam.owntask.step;

import com.epam.owntask.page.SettingsPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class SettingsPageSteps extends AbstractSteps {
    private SettingsPage settingsPage;

    public SettingsPageSteps(WebDriver driver) {
        super(driver);
        settingsPage = new SettingsPage(driver);
    }

    public ForwardingAndPOPMAPPageSteps enterToForwardingAndPOPMAPPage(){
        log.info("Enter to Forward and POPMAP page");
        settingsPage.enterToForwardingAndPOPMAPPage();
        return new ForwardingAndPOPMAPPageSteps(driver);
    }

    public FiltersPageSteps enterToFiltersPage(){
        log.info("Enter to filters page");
        settingsPage.enterToFiltersPage();
        return new FiltersPageSteps(driver);
    }

    public ThemesPageSteps enterToThemesPage(){
        log.info("Enter to themes page");
        settingsPage.enterToThemesPage();
        return new ThemesPageSteps(driver);
    }
}
