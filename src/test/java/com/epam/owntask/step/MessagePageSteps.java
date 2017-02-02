package com.epam.owntask.step;

import com.epam.owntask.page.MessagePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class MessagePageSteps extends AbstractSteps {
    private MessagePage messagePage;

    public MessagePageSteps(WebDriver driver) {
        super(driver);
        messagePage = new MessagePage(driver);
    }

    public MainPageSteps confirmRequestForward(){
        log.info("Confirm forward request");
        messagePage.confirmRequestForward();
        return new MainPageSteps(driver);
    }

    public boolean hasEmoticon(){
        log.info("Check emoticons");
        return messagePage.hasEmotion();
    }
}
