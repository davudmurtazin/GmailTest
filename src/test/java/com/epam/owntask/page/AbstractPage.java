package com.epam.owntask.page;

import com.epam.owntask.util.ExplicitWait;
import com.epam.owntask.util.SwitchUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected SwitchUtil switchUtil;
    protected ExplicitWait wait;
    protected static final Logger log = LogManager.getRootLogger();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        switchUtil = new SwitchUtil(this.driver);
        wait = new ExplicitWait(this.driver);
    }
}
