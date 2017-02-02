package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.ForwardingAndPOPMAPPage;
import com.epam.owntask.page.MainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class ForwardingAndPOPMAPPageSteps extends AbstractSteps {
    private ForwardingAndPOPMAPPage forwardingAndPOPMAPPage;

    public ForwardingAndPOPMAPPageSteps(WebDriver driver) {
        super(driver);
        forwardingAndPOPMAPPage = new ForwardingAndPOPMAPPage(driver);
    }

    public ConfirmPageSteps addForward(User user){
        log.info("Adding forward");
        forwardingAndPOPMAPPage.addForward(user);
        return new ConfirmPageSteps(driver);
    }

    public MainPageSteps forwardIncomingMessage(){
        log.info("Forward incoming message");
        forwardingAndPOPMAPPage.forwardCopyTo();
        return new MainPageSteps(driver);
    }
}
