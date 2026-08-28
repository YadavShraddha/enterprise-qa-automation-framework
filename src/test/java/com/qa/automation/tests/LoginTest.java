package com.qa.automation.tests;
import com.qa.automation.config.ConfigReader;

import com.qa.automation.config.ConfigReader;
import com.qa.automation.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void verifyOrangeHRMTitle(){
        driver.get(ConfigReader.getProperty("baseUrl"));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"OrangeHRM");
    }
}