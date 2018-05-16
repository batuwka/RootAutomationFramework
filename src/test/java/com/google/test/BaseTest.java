package com.google.test;

import com.browser.utils.PropertyUtils;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Map;

public class BaseTest {

    @BeforeClass
    public void initialization(){
        String path = new File("Readme.md").getAbsolutePath();
        Map<String, String> properties = PropertyUtils.readProperties(path.replace("Readme.md","") + "src\\test\\resources\\properties\\path.properties");
        for (Map.Entry<String,String> property : properties.entrySet())
        {
            System.setProperty(property.getKey(), property.getValue());
        }
    }
}
