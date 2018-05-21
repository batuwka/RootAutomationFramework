package com.google.pageobjekts.home;

import com.google.pageobjekts.BaseMobilePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMobile extends BaseMobilePageObject {

    public LoginPageMobile(WebDriver driver) {
        super(driver);
    }

    public LoginPageMobile invalidLogin() {
        driver.get("https://www.yandex.ru/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5000");
        driver.findElement(By.xpath("(//*[@type='search'])[1]")).sendKeys("Anton Gordynets");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("10000");
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("15000");
        return new LoginPageMobile(driver);
    }
}
