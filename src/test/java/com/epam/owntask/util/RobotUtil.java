package com.epam.owntask.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Davud_Murtazin on 1/4/2017.
 */
public class RobotUtil {
    protected static final Logger log = LogManager.getRootLogger();
    private Robot robot;

    public void enterPathByRobot(String filePath) {
        try {
            robot = new Robot();
            StringSelection ss = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            log.info("Could not create robot!");
        }
    }

    public void addEmoticonsByRobot(List<WebElement> allEmoticons, int countOfEmotions, ExplicitWait wait) {
        try {
            robot = new Robot();
            for (int i = 0; i < countOfEmotions; i++) {
                int indexOfEmotion = new Random().nextInt(allEmoticons.size());
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                wait.waitForElementIsClickable(allEmoticons.get(indexOfEmotion)).click();
            }
        } catch (AWTException e) {
            log.info("Could not create robot!");
        }
    }
}
