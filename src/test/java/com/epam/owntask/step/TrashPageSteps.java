package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.TrashPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 1/4/2017.
 */
public class TrashPageSteps extends AbstractSteps {
    private TrashPage trashPage;

    public TrashPageSteps(WebDriver driver) {
        super(driver);
        trashPage = new TrashPage(driver);
    }

    public boolean hasAnyMessageWithAttachment(User user){
        log.info("Check trash page");
        return trashPage.hasAnyMessageWithAttachment(user);
    }
}
