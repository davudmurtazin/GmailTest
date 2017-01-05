package com.epam.owntask.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Davud_Murtazin on 12/10/2016.
 */
public class ThreadSleep {
    protected static final Logger log = LogManager.getRootLogger();

    public static void waitElement(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
