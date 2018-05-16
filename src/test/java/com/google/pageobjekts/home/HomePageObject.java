package com.google.pageobjekts.home;

import com.google.pageobjekts.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePageObject {


    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(getLocator("search.button"))).click();
    }

    public void writeSearchRequest(String request){
        driver.findElement(By.xpath(getLocator("input.search"))).sendKeys(request);
    }
}
