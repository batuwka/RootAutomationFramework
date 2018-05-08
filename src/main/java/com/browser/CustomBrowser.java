package com.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomBrowser {

    private static final String HUB_PROPERTIES_PATH = System.getProperty("hubProperties");

    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public WebDriver getDriver() {
        String driverType = System.getProperty("driver.type");
        WebDriver driver;
        switch (driverType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }
}
