package com.google.test.search;

import com.browser.CustomBrowser;
import com.google.pageobjekts.home.HomePageObject;
import com.google.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchGoogleTest extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;

    @BeforeClass()
    public void beforeClass() {
        CustomBrowser cb = new CustomBrowser();
        this.driver = cb.getDriver();
        this.homePageObject = new HomePageObject(this.driver);
    }


    @Test()
    public void testGoogleSearchPage() {
        driver.navigate().to("https://www.google.es/");
        homePageObject.writeSearchRequest("vk");
        homePageObject.clickSearchButton();
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
