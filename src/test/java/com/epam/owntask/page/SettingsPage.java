package com.epam.owntask.page;

import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class SettingsPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(text(),'Forwarding and POP/IMAP')]")
    private WebElement buttonForwardingAndPOPIMAP;

    @FindBy(xpath = "//a[contains(text(),'Filters and Blocked Addresses')]")
    private WebElement buttonFilter;

    @FindBy(xpath = "//a[contains(text(),'Themes')]")
    private WebElement buttonThemes;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void enterToForwardingAndPOPMAPPage() {
        wait.waitForElementIsClickable(buttonForwardingAndPOPIMAP).click();
    }

    public void enterToFiltersPage(){
        wait.waitForElementIsClickable(buttonFilter).click();
    }

    public void enterToThemesPage(){
        wait.waitForElementIsClickable(buttonThemes).click();
    }
}
