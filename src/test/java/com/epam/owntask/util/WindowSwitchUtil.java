package com.epam.owntask.util;

import com.epam.owntask.page.AbstractPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class WindowSwitchUtil {

    private WebDriver driver;

    public WindowSwitchUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindow(){
        String currentWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if(!handle.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(handle);
                ThreadSleep.waitElement(2500);
                break;
            }
        }
    }
}
