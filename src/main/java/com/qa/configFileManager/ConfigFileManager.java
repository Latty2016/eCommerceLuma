package com.qa.configFileManager;


import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
    public static PropertiesConfiguration configuration = null;

    public static final Properties properties = new Properties();       //If you want to use config files. u should create a Properties Object in here.

    public static String readValue(String config_properties, String key){   //Method name and set return what kind of data type(in here this method should be return "String" data type. And define the params ( income data and these data's type).
        String value;               //In config.properties files, all data stored with fixed structure: key-value structure. Config file's key should be inputted as params when user call this method, Correspondingly we have to declare its value. Because We have to return this value in the end of method.

        try {
            properties.load(new FileInputStream(config_properties));        //Then call this object's load method and give upper method(in here is:"readValue" method is upper method to load method)'s params which config.properties file name. Well, Because we are openning a file with filestream, so do not forget use try-catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value = properties.getProperty(key);               //After config file is opened, get value Corresponding to the key and assign the read value to "value" String variable.
        System.out.println("Reading value From config.properties:\n" +
                "Key: " + key +"\n" +
                "Value: " + value + "\n");      //In this section, I want to let the console output which value that I get from file, Because it will help me to handle error that I meet in the future.

        return value;           //return the value that we got from config file. If you do not return any data from this method, there is no meaning to use this method.
    }

}
