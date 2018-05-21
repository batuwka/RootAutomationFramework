package com.google.test.mobile;

import com.google.pageobjekts.home.LoginPageMobile;
import com.google.test.BaseMobileTest;
import org.testng.annotations.Test;

public class SearchGoogleMobileTest extends BaseMobileTest {

    @Test()
    public void helloTest()
    {
        new LoginPageMobile(driver).invalidLogin();
    }
}
