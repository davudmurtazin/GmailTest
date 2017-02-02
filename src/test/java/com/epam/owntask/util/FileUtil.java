package com.epam.owntask.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Davud_Murtazin on 1/5/2017.
 */
public class FileUtil {
    protected static final Logger log = LogManager.getRootLogger();

    public static String createFile(String fileName, double fileSize){
        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            while (file.length() <= fileSize) {
                writer.write(String.valueOf(Double.MAX_VALUE));
                writer.write("0123456789112312346547654");
                writer.write("abcdefghijklnopqrstuvwxuz");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static void deleteFile(String filePath){
        File file = new File(filePath);
        if(file.delete()){
            log.info("File deleted!");
        }else{
            log.info("File could not be deleted!");
        }
    }
}
