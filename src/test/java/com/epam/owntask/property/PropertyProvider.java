package com.epam.owntask.property;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {
    private static PropertyProvider instance = null;
    private static Properties properties = new Properties();
    private static String propPath = "src\\test\\resources\\config.properties";
    private static final Logger log = LogManager.getRootLogger();

    private PropertyProvider() {
        propPath = FilenameUtils.separatorsToSystem(new File("").getAbsolutePath() + "\\" + propPath);
        loadProperties(propPath);
    }

    private void loadProperties(String fileName) {
        File localFile = new File(fileName);
        if (!localFile.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
                properties.load(fis);
                fis.close();
            } catch (IOException e) {
                log.info(e.getMessage());
                System.out.println("Exception's happened trying to load props from: " + fileName);
            }
        }
    }

    public static String getProperty(String propertyName) {
        if(instance == null) instance = new PropertyProvider();

        String propertyValue;
        if ((System.getProperty(propertyName) != null)) {
            propertyValue = System.getProperty(propertyName);
        } else
            propertyValue = PropertyProvider.properties.getProperty(propertyName);
        return propertyValue;
    }
}

