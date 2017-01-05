package com.epam.owntask.step;

import com.epam.owntask.page.ConfirmPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class ConfirmPageSteps extends AbstractSteps {
    private ConfirmPage confirmPage;

    public ConfirmPageSteps(WebDriver driver) {
        super(driver);
        confirmPage = new ConfirmPage(driver);
    }

    public MainPageSteps continueAddingForward(){
        log.info("Continue adding forward");
        confirmPage.confirmForward();
        return new MainPageSteps(driver);
    }
}
