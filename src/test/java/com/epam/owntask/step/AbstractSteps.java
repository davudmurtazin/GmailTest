package com.epam.owntask.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class AbstractSteps {
    protected static final Logger log = LogManager.getRootLogger();

    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }
}