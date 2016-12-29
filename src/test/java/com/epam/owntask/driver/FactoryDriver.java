package com.epam.owntask.driver;

import com.epam.owntask.property.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Davud_Murtazin on 11/20/2016.
 */
public class FactoryDriver {
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_EXE_PATH = "\\driver\\geckodriver.exe";
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_EXE_PATH = "\\driver\\chromedriver.exe";
    private static final Logger log = LogManager.getRootLogger();
    private static WebDriver driver;

    private FactoryDriver() {
    }

    private static WebDriver getActualDriver() {
        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));
        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                log.info("Chrome driver created");
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                log.info("Firefox driver created");
                break;
            default:
                driver = createFirefoxDriver();
                log.info("Firefox driver created");
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            getActualDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        log.info("Driver has been closed");
    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_EXE_PATH);
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }
}

