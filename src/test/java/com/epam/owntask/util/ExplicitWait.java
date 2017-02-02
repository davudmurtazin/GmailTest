package com.epam.owntask.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    private WebDriver driverWait;
    private Wait<WebDriver> wait;

    public ExplicitWait(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, 10).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator!");
    }

    public WebElement waitForElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
