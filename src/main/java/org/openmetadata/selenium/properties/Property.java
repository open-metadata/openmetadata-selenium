package org.openmetadata.selenium.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private static String PATH;
    private static Integer waitTime;
    private static final Object lock = new Object();
    private static Property instance;

    public static Property getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Property();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("selenium.properties"));
        } catch (IOException ignored) {}
        PATH = properties.getProperty("path");
        waitTime = Integer.parseInt(properties.getProperty("waitTime"));
    }

    public static String getPath() {
        return PATH;
    }
    public static Integer getSleepTime() {
        return waitTime;
    }
}
