package com.endtoend.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ElementLocator {
    private static Properties properties;

    static {
            try {
                properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/elements.properties");
                properties.load(fileInputStream);
                fileInputStream.close();

            }
            catch (IOException e){
                e.printStackTrace();
            }
    }

    public static String getLocator(String key){
        return properties.getProperty(key);
    }
}
