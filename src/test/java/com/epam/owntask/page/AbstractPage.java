package com.epam.owntask.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final Logger log = LogManager.getRootLogger();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
