package com.browser.utils;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    /**
     * Method for get property value from file in classpath.
     *
     * @param propertyFilePath path to properties file in classpath
     * @param propertyName     property name in file
     * @return property value
     */
    public static String getSystemPropertyValue(String propertyFilePath, String propertyName) {
        String propertyValue = "";
        InputStream inputStream = null;
        try {
            Properties properties = new Properties();
            inputStream = new FileInputStream(new File(propertyFilePath));
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
            if (propertyValue == null) {
                String error = "Can't get property value [" + propertyName + "] from file in classpath [" + propertyFilePath + "]. Check if this property exists in file.";
                throw new RuntimeException(error);
            }
        } catch (Exception e) {
            String error = "Can't load properties file [" + propertyFilePath + "]. Property name is " + propertyName;
            throw new RuntimeException(error, e);
        } finally {
            //close input stream
            IOUtils.closeQuietly(inputStream);
        }
        return propertyValue;
    }


    /**
     * Method for get property value from file in classpath.
     *
     * @param propertyFilePath path to properties file in classpath
     * @param propertyName     property name in file
     * @return property value
     */
    public static String getClasspathPropertyValue(String propertyFilePath, String propertyName) {
        String propertyValue = "";
        Properties properties = new Properties();
        InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(propertyFilePath);
        Reader isr = null;
        if (inputStream != null) {
            try {
                isr = new InputStreamReader(inputStream, "UTF-8");
                properties.load(isr);
            } catch (IOException e) {
                String error = "Can't load properties file by path [" + propertyFilePath + "] cause: \n" + e.getLocalizedMessage();
                throw new RuntimeException(error, e);
            }
        } else {
            String error = "Can't load properties file [" + propertyFilePath + "] from calsspath.";
            throw new RuntimeException(error);
        }
        propertyValue = properties.getProperty(propertyName);
        if (propertyValue == null) {
            String error = "Can't get property value [" + propertyName + "] from file in classpath [" + propertyFilePath + "]. Check if this property exists in file.";
            throw new RuntimeException(error);
        }
        //close input stream
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(isr);
        return propertyValue;
    }

    /**
     * Method for write properties to file. If the properties file exists then this file would be replaced.
     *
     * @param propertiesPath file path for properties
     * @param properties     properties collection
     */
    public static void writeProperties(String propertiesPath, Map<String, String> properties) {
        if (propertiesPath == null || "".equals(propertiesPath) || properties == null || properties.size() == 0) {
            String error = "Can't write properties to file cause parameters are not valid. File path is [" + propertiesPath + "] properties map is [" + properties + "].";
            throw new RuntimeException(error);
        }
        OutputStream outputStream = null;
        try {
            Properties prop = new Properties();
            for (String key : properties.keySet()) {
                prop.setProperty(key, properties.get(key));
            }
            //rewrite properties file
            prop.store(new FileWriter(propertiesPath), "");
        } catch (IOException e) {
            String error = "Can't write the properties cause: \n" + e.getLocalizedMessage();
            throw new RuntimeException(error, e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    public static Map<String, String> readProperties(String propertiesPath) {
        if (propertiesPath == null || "".equals(propertiesPath)) {
            String error = "Can't read properties from file cause path is empty";
            throw new RuntimeException(error);
        }
        Properties prop = new Properties();
        InputStream input;

        try {

            input = new FileInputStream(propertiesPath);

            prop.load(input);
            return (Map) prop;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
