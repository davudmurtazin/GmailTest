package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.SpamPage;
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

    public boolean hasAnyMessageFromUser(User user){
        log.info("Check spam page");
        return spamPage.hasAnyMessageFromUser(user);
    }
}
