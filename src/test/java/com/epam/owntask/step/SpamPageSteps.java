package com.epam.owntask.step;

import com.epam.owntask.page.SpamPage;
import com.epam.owntask.step.exception.StepsException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class SpamPageSteps extends AbstractSteps {
    private SpamPage spamPage;

    public SpamPageSteps(WebDriver driver) {
        super(driver);
        spamPage = new SpamPage(driver);
    }

    public boolean isSpamPage(){
        log.info("Check spam page");
        boolean flag = false;
        try {
            flag = spamPage.isSpamPage();
        } catch (InterruptedException e) {
            new StepsException(e.getMessage());
        }
        return flag;
    }
}
