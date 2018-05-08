package com.google.search;

import com.browser.CustomBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchGoogleTest {
    private WebDriver driver;

    @BeforeClass()
    public void beforeClass() {
        CustomBrowser cb = new CustomBrowser();
        driver = cb.getDriver();
    }


    @Test()
    public void testGoogleSearchPage() {
        driver.navigate().to("https://www.google.es/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass()
    public void closeBrowser() {
        driver.close();
    }
}
