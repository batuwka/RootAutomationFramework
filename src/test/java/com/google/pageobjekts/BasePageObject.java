package com.google.pageobjekts;


import com.browser.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

public class BasePageObject {
    final String LOCATORS_PATH;
    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.LOCATORS_PATH = System.getProperty("LOCATORS_PATH");
        this.driver = driver;
    }

    protected String getLocator(final String locatorName) {
        if (locatorName == null || locatorName.trim().equals("")) {
            String error = "Can't get locator from " + LOCATORS_PATH + " path cause locator name value is empty or NULL. Value is[" + locatorName + "]";
            throw new RuntimeException(error);
        }
        return PropertyUtils.getClasspathPropertyValue(LOCATORS_PATH, locatorName);
    }
}
