package com.epam.owntask.page;

import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class SettingsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='nH fY']/div[6]/a")
    private WebElement buttonForwardingAndPOPIMAP;

    @FindBy(xpath = "//div[@class='nH fY']/div[5]/a")
    private WebElement buttonFilter;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void enterToForwardingAndPOPMAPPage() {
        wait.waitForElementIsClickable(buttonForwardingAndPOPIMAP).click();
    }

    public void enterToFiltersPage(){
        wait.waitForElementIsClickable(buttonFilter).click();
    }
}
